import java.util.Iterator;
import org.biojava.bio.dist.Distribution;
import org.biojava.bio.dist.DistributionTools;
import org.biojava.bio.dist.UniformDistribution;
import org.biojava.bio.symbol.SimpleSymbolList;
import org.biojava.bio.symbol.SymbolList;
import org.biojavax.ga.GAStoppingCriteria;
import org.biojavax.ga.Population;
import org.biojavax.ga.Organism;
import org.biojavax.ga.GeneticAlgorithm;
import org.biojavax.ga.impl.SimplePopulation;
import org.biojavax.ga.impl.SimpleOrganism;
import org.biojavax.ga.impl.SimpleGeneticAlgorithm;
import org.biojavax.ga.util.GATools;
import org.biojavax.ga.functions.FitnessFunction;
import org.biojavax.ga.functions.CrossOverFunction;
import org.biojavax.ga.functions.SelectionFunction;
import org.biojavax.ga.functions.ProportionalSelection;
import org.biojavax.ga.functions.MutationFunction;
import org.biojavax.ga.functions.SimpleMutationFunction;
import org.biojavax.ga.functions.SimpleCrossOverFunction;
�
/**
 * <p>
 * Demos a very Simple GA. It will run until one organism contains a chromosome
 * that is 75% ones
 * </p>
 *
 * @author Mark Schreiber
 * @author Susanne Merz
 * @author Andreas Dr&auml;ger
 * @version 1.1
 */
�
public class GADemo {
	public static void main(String[] args) throws Exception {
		// print the header
		System.out.println("gen,average_fitness,best_fitness");
�
		// a uniform Distribution over the binary Alphabet
		Distribution bin_dist = new UniformDistribution(GATools.getBinaryAlphabet());
�
		// initialize the population
		Population pop = new SimplePopulation("demo population");
�
		// add 100 organisms
		for (int i = 0; i < 100; i++) {
			Organism o = new SimpleOrganism("organism" + i);
�
			// make 1 random chromosome for each organism
			SymbolList[] ch = new SymbolList[1];
			// the symbols are randomly sampled from bin_dist
			ch[0] = new SimpleSymbolList(DistributionTools.generateSequence("",
			    bin_dist, 100));
�
			// set the organisms chromosome to be ch
			o.setChromosomes(ch);
�
			// add to organism to the population pop
			pop.addOrganism(o);
		}
�
		// created a SelectionFunction
		SelectionFunction sf = new ProportionalSelection();
�
		// create a new CrossOverFunction
		CrossOverFunction cf = new SimpleCrossOverFunction();
		// set the max number of cross overs per chromosome
		cf.setMaxCrossOvers(1);
		// set a uniform cross over probability of 0.01
		cf.setCrossOverProbs(new double[] {0.01});
�
		// create a new MutationFunction
		MutationFunction mf = new SimpleMutationFunction();
		// set a uniform MutationProbability of 0.0001
		mf.setMutationProbs(new double[] {0.0001});
		// set the mutation spectrum of the function to be a standard
		// mutation distribution over the binary Alphabet
		mf.setMutationSpectrum(GATools.standardMutationDistribution(GATools
		    .getBinaryAlphabet()));
�
		// make a GeneticAlgorithm with the above functions
		GeneticAlgorithm genAlg = new SimpleGeneticAlgorithm(pop, mf, cf, sf);
		// set its FitnessFunction
		genAlg.setFitnessFunction(new DemoFitness());
		// run the Algorithm until the criteria of DemoStopping are met
		genAlg.run(new DemoStopping());
	}
�
	/**
	 * Basic implementation of GAStopping Criteria
	 */
	static class DemoStopping implements GAStoppingCriteria {
�
		/**
		 * Determines when to stop the Algorithm
		 */
		public boolean stop(GeneticAlgorithm genAlg) {
			System.out.print(genAlg.getGeneration() + ",");
			Population pop = genAlg.getPopulation();
			int i;
			double totalFit = 0.0;
�
			FitnessFunction ff = genAlg.getFitnessFunction();
�
			double fit[] = {0.0};
			double bestFitness[] = {0.0};
�
			for (Iterator it = pop.organisms(); it.hasNext();) {
				Organism o = (Organism) it.next();
				fit = ff.fitness(o, pop, genAlg);
				for (i = 0; i < fit.length; i++) {
					bestFitness[i] = Math.max(fit[i], bestFitness[i]);
					totalFit += fit[i];
				}
			}
�
			// print the average fitness
			System.out.print((totalFit / (double) pop.size()) + ",");
			// print the best fitness
			System.out.println(bestFitness[0]);
�
			// fitness is 75.0 so stop the algorithm
			boolean good = false;
			for (i = 0; (i < bestFitness.length) && !good; i++) {
				if (bestFitness[i] >= 75.0) {
					good = true;
					System.out.println("Organism found with Fitness of 75%");
				}
			}
			// organism is fit enough, continue the algorithm
			return good;
		}
	}
�
	/**
	 * A fitness function bases on the most "one" rich chromosome in the organism.
	 */
	static class DemoFitness implements FitnessFunction {
		public double[] fitness(Organism o, Population p, GeneticAlgorithm genAlg) {
			double bestfit[] = {0.0};
�
			for (int i = 0; i < o.getChromosomes().length; i++) {
				SymbolList csome = o.getChromosomes()[i];
				double fit = 0.0;
				for (int j = 1; j <= csome.length(); j++) {
					if (csome.symbolAt(j) == GATools.one()) fit++;
				}
				bestfit[0] = Math.max(fit, bestfit[0]);
			}
�
			return bestfit;
		}
	}
}