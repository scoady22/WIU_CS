CC = gcc
CFLAGS = 

#The executable 'matrix' depends on the matrix object file
matrix: matrix.o
	$(CC) $(CFLAGS) -o matrix matrix.o -lpthread

#Build matrix.o (requires matrix.o)
matrix.o : matrix.c
	$(CC) $(CFLAGS) -c matrix.c

#Clean: remove all the object files
clean : 
	rm matrix *.o
