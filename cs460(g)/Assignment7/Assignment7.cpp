// CS 465
// Assignment 3
// Author:


#include "../shared/gltools.h"	// OpenGL toolkit

#define EARTH_DEGREES_PER_SECOND 1

#define AU 10// distance
#define SCALE 0.2 //size of planet

#define DISTANCE 10

#define SUN_COLOR 1,1,0
#define MERCURY_COLOR .733,.733,.733
#define VENUS_COLOR .8,.6,.2
#define MOON_COLOR .47,.47,.47
#define EARTH_COLOR .04,.5,1
#define MARS_COLOR 1,.1,.1
#define JUPITER_COLOR 1,.4,.4
#define SATURN_COLOR .6,.6,.2
#define URANUS_COLOR .733,.733,.733
#define NEPTUNE_COLOR .01,1,1


#define EARTH_RADIUS 0.02
#define MARS_ORBIT_RADIUS 1.52
#define MERCURY_ORBIT_RADIUS 0.39
#define VENUS_ORBIT_RADIUS 0.72
#define MOON_ORBIT_RADIUS 0.0257 //obviously not a real value - used for visual reasons
#define EARTH_ORBIT_RADIUS 1
#define SUN_ORBIT_RADIUS 0
#define JUPITER_ORBIT_RADIUS 5.2
#define SATURN_ORBIT_RADIUS 9.54
#define URANUS_ORBIT_RADIUS 19.18
#define NEPTUNE_ORBIT_RADIUS 30.06

#define MARS_DIAMETER 0.532
#define MERCURY_DIAMETER 0.382
#define VENUS_DIAMETER 0.949
#define MOON_DIAMETER 0.25
#define EARTH_DIAMETER 1
#define SUN_DIAMETER 15 //obviously not a real value - used for visual reasons
#define JUPITER_DIAMETER 11.209
#define SATURN_DIAMETER 9.44
#define URANUS_DIAMETER 4.007
#define NEPTUNE_DIAMETER 3.883

#define MARS_ORBIT_PERIOD 1.881
#define MERCURY_ORBIT_PERIOD 0.241
#define VENUS_ORBIT_PERIOD 0.615
#define MOON_ORBIT_PERIOD 0.0748
#define EARTH_ORBIT_PERIOD 1
#define SUN_ORBIT_PERIOD 0
#define JUPITER_ORBIT_PERIOD 11.86
#define SATURN_ORBIT_PERIOD 29.46
#define URANUS_ORBIT_PERIOD 84.32
#define NEPTUNE_ORBIT_PERIOD 164.8

#define EARTH_TILT 23.5
#define MARS_TILT 25.0
#define MERCURY_TILT 0.0
#define VENUS_TILT 177.0
#define MOON_TILT 1.54
#define SUN_TILT 23.5
#define JUPITER_TILT 3.0
#define SATURN_TILT 27.0
#define URANUS_TILT 98.0
#define NEPTUNE_TILT 30.0

#define EARTH_INCLINATION 0
#define MARS_INCLINATION 1.85
#define MERCURY_INCLINATION 7.01
#define VENUS_INCLINATION 3.86
#define MOON_INCLINATION 5.15
#define SUN_INCLINATION 0
#define JUPITER_INCLINATION 1.31
#define SATURN_INCLINATION 2.49
#define URANUS_INCLINATION 0.77
#define NEPTUNE_INCLINATION 1.77

#define MARS_ROTATION_PERIOD 1.027
#define MERCURY_ROTATION_PERIOD 175.94
#define VENUS_ROTATION_PERIOD -116.75
#define MOON_ROTATION_PERIOD 27.321
#define EARTH_ROTATION_PERIOD 1
#define SUN_ROTATION_PERIOD 1
#define JUPITER_ROTATION_PERIOD 0.414
#define SATURN_ROTATION_PERIOD 0.439
#define URANUS_ROTATION_PERIOD -0.718
#define NEPTUNE_ROTATION_PERIOD 16.11

#define PI 3.14159265


float MercuryOrbit = 0.0;
float VenusOrbit = 0.0;
float EarthOrbit = 0.0;
float MoonOrbit = 0.0;
float MarsOrbit = 0.0;
float JupiterOrbit = 0.0;
float SaturnOrbit = 0.0;
float UranusOrbit = 0.0;
float NeptuneOrbit = 0.0;

float MercurySpin = 0.0;
float VenusSpin = 0.0;
float EarthSpin = 0.0;
float MarsSpin = 0.0;
float JupiterSpin = 0.0;
float SaturnSpin = 0.0;
float UranusSpin = 0.0;
float NeptuneSpin = 0.0;


bool lookUp;
bool lookDown;
bool lookLeft;
bool lookRight;
bool walkForward;
bool walkBackward;
bool strafeLeft;
bool strafeRight;
float xTranslation;
float yTranslation;
float zTranslation;
float yRotationAngle;
float zRotationAngle;
float xRotationAngle;
int MouseCordx;
int MouseCordy;


// Light values and coordinates
GLfloat	 lightPos[] = { 0.0f, 0.0f, 0.0f, 1.0f };
GLfloat  specular[] = { 1.0f, 1.0f, 1.0f, 1.0f};
GLfloat  diffuse[] = { 1.0f, 1.0f, 1.0f, 1.0f};
GLfloat  diffuseref[] =  { 1.0f, 1.0f, 1.0f, 1.0f };
GLfloat  ambientref[] =  { 1.0f, 1.0f, 1.0f, 1.0f };
GLfloat  specref[] =  { 1.0f, 1.0f, 1.0f, 1.0f };
GLfloat  ambientLight[] = { 0.0f, 0.0f, 0.0f, 0.0f};




//declared planet textures so far
#define NUM_TEXTURES 10
GLuint textureObjects[NUM_TEXTURES];
const char *szTextureFiles[] = {"sun.tga","mercury.tga","venus.tga","earth.tga","moon.tga","mars.tga","jupiter.tga","saturn.tga","uranus.tga","neptune.tga"};

/*
GLuint  textureObjects[NUM_TEXTURES];
#define SUN_TEX 0
#define MERCURY_TEX 1
*/




// Six sides of a cube map
const char *szCubeFaces[6] = { "GalaxyRt.tga", "GalaxyLf.tga", "GalaxyUp.tga", "GalaxyDn.tga", "GalaxyBk.tga", "GalaxyFt.tga" };

GLenum  cube[6] = {  GL_TEXTURE_CUBE_MAP_POSITIVE_X,
                     GL_TEXTURE_CUBE_MAP_NEGATIVE_X,
                     GL_TEXTURE_CUBE_MAP_POSITIVE_Y,
                     GL_TEXTURE_CUBE_MAP_NEGATIVE_Y,
                     GL_TEXTURE_CUBE_MAP_POSITIVE_Z,
                     GL_TEXTURE_CUBE_MAP_NEGATIVE_Z };



void mouseCam(int x, int y) 
{
	int mouseDiffx=x-MouseCordx; 
	int mouseDiffy=y-MouseCordy; 
	MouseCordx=x; 
	MouseCordy=y; //set lasty to the current y position
	xRotationAngle -= ((GLfloat) mouseDiffy)*0.1; 
	yRotationAngle += ((GLfloat) mouseDiffx)*0.1;
	if (xRotationAngle>=180)
			xRotationAngle=180;
	if (xRotationAngle<=-180)
			xRotationAngle=-180;
	//cout << "x:" << x << "y:" << y << endl;
}

//Draw the Skybox
void DrawSkyBox(void)
    {
    GLfloat fExtent = 500.0f;
    glEnable(GL_TEXTURE_CUBE_MAP);
	glTexEnvi(GL_TEXTURE_ENV, GL_TEXTURE_ENV_MODE, GL_DECAL);
    glBegin(GL_QUADS);
        //////////////////////////////////////////////
        // Negative X
        glTexCoord3f(-1.0f, -1.0f, 1.0f);
        glVertex3f(-fExtent, -fExtent, fExtent);
        
        glTexCoord3f(-1.0f, -1.0f, -1.0f);
        glVertex3f(-fExtent, -fExtent, -fExtent);
        
        glTexCoord3f(-1.0f, 1.0f, -1.0f);
        glVertex3f(-fExtent, fExtent, -fExtent);
        
        glTexCoord3f(-1.0f, 1.0f, 1.0f);
        glVertex3f(-fExtent, fExtent, fExtent);


        ///////////////////////////////////////////////
        //  Postive X
        glTexCoord3f(1.0f, -1.0f, -1.0f);
        glVertex3f(fExtent, -fExtent, -fExtent);
        
        glTexCoord3f(1.0f, -1.0f, 1.0f);
        glVertex3f(fExtent, -fExtent, fExtent);
        
        glTexCoord3f(1.0f, 1.0f, 1.0f);
        glVertex3f(fExtent, fExtent, fExtent);
        
        glTexCoord3f(1.0f, 1.0f, -1.0f);
        glVertex3f(fExtent, fExtent, -fExtent);
 

        ////////////////////////////////////////////////
        // Negative Z 
        glTexCoord3f(-1.0f, -1.0f, -1.0f);
        glVertex3f(-fExtent, -fExtent, -fExtent);
        
        glTexCoord3f(1.0f, -1.0f, -1.0f);
        glVertex3f(fExtent, -fExtent, -fExtent);
        
        glTexCoord3f(1.0f, 1.0f, -1.0f);
        glVertex3f(fExtent, fExtent, -fExtent);
        
        glTexCoord3f(-1.0f, 1.0f, -1.0f);
        glVertex3f(-fExtent, fExtent, -fExtent);


        ////////////////////////////////////////////////
        // Positive Z 
        glTexCoord3f(1.0f, -1.0f, 1.0f);
        glVertex3f(fExtent, -fExtent, fExtent);
        
        glTexCoord3f(-1.0f, -1.0f, 1.0f);
        glVertex3f(-fExtent, -fExtent, fExtent);
        
        glTexCoord3f(-1.0f, 1.0f, 1.0f);
        glVertex3f(-fExtent, fExtent, fExtent);
        
        glTexCoord3f(1.0f, 1.0f, 1.0f);
        glVertex3f(fExtent, fExtent, fExtent);


        //////////////////////////////////////////////////
        // Positive Y
        glTexCoord3f(-1.0f, 1.0f, 1.0f);
        glVertex3f(-fExtent, fExtent, fExtent);
        
        glTexCoord3f(-1.0f, 1.0f, -1.0f);
        glVertex3f(-fExtent, fExtent, -fExtent);
        
        glTexCoord3f(1.0f, 1.0f, -1.0f);
        glVertex3f(fExtent, fExtent, -fExtent);
        
        glTexCoord3f(1.0f, 1.0f, 1.0f);
        glVertex3f(fExtent, fExtent, fExtent);
  
    
        ///////////////////////////////////////////////////
        // Negative Y
        glTexCoord3f(-1.0f, -1.0f, -1.0f);
        glVertex3f(-fExtent, -fExtent, -fExtent);
        
        glTexCoord3f(-1.0f, -1.0f, 1.0f);
        glVertex3f(-fExtent, -fExtent, fExtent);
        
        glTexCoord3f(1.0f, -1.0f, 1.0f);
        glVertex3f(fExtent, -fExtent, fExtent);
        
        glTexCoord3f(1.0f, -1.0f, -1.0f);
        glVertex3f(fExtent, -fExtent, -fExtent);
    glEnd();
	glDisable(GL_TEXTURE_CUBE_MAP);
	glTexEnvi(GL_TEXTURE_ENV, GL_TEXTURE_ENV_MODE, GL_MODULATE);
    
    }


///////////////////////////////////////////////////////////
// Called to draw scene
void RenderScene(void)
{

	GLUquadricObj *pObj;	// Quadric Object
	pObj = gluNewQuadric(); 
	gluQuadricNormals(pObj, GLU_SMOOTH);

	GLfloat horizontalMovement=1;
	GLfloat verticalMovement=0;
	horizontalMovement=cos(xRotationAngle*PI/180);
	verticalMovement=-sin(xRotationAngle*PI/180);
	
	if (lookDown)
	{
		xRotationAngle+=1;
		if (xRotationAngle>=360)
			xRotationAngle=0;
	}
	if (lookUp)
	{
		xRotationAngle-=1;
		if (xRotationAngle<=-360)
			xRotationAngle=0;
	}
	if (lookRight)
	{
		yRotationAngle+=1;
		if (yRotationAngle>=360)
			yRotationAngle=0;
	}
	if (lookLeft)
	{
		yRotationAngle-=1;
		if (yRotationAngle<=-360)
			yRotationAngle=0;
	}
	if (walkForward)
	{
		zTranslation+=horizontalMovement*cos(yRotationAngle*PI/180);
		xTranslation-=horizontalMovement*sin(yRotationAngle*PI/180);
		yTranslation-=verticalMovement;
	}
	if (walkBackward)
	{
		zTranslation-=horizontalMovement*cos(yRotationAngle*PI/180);
		xTranslation+=horizontalMovement*sin(yRotationAngle*PI/180);
		yTranslation+=verticalMovement;
	}
	if (strafeRight)
	{
		zTranslation+=cos((yRotationAngle+90)*PI/180);
		xTranslation-=sin((yRotationAngle+90)*PI/180);
	}
	if (strafeLeft)
	{
		zTranslation-=cos((yRotationAngle+90)*PI/180);
		xTranslation+=sin((yRotationAngle+90)*PI/180);
	}


	//Orbit
	GLUquadric *orbitQuad = gluNewQuadric();
	gluQuadricDrawStyle(orbitQuad , GLU_LINE );

	GLUquadric *planetQuad = gluNewQuadric();


		// Reset Model view matrix stack
	glMatrixMode(GL_MODELVIEW);
	glLoadIdentity();


	
	



	// Clear the window with current clearing color
	glClear(GL_COLOR_BUFFER_BIT |  GL_DEPTH_BUFFER_BIT);
	glPolygonMode(GL_FRONT_AND_BACK,GL_FILL);
	
	glRotatef(xRotationAngle,1,0,0);
	//glRotatef(zRotationAngle,0,0,1);
	glRotatef(yRotationAngle,0,1,0);
		DrawSkyBox();
	glTranslatef(xTranslation,yTranslation,zTranslation);
	glTranslatef(0,0,-30);
	/*
	glLineWidth(2);
	glBegin(GL_LINES);
		//x
	    /*
		glColor3f(1,0,0);
		glVertex3f(-300,0,0);
		glVertex3f(300,0,0);
		*/
		/*
		//y
		glColor3f(0,1,0);
		glVertex3f(0,-20,0);
		glVertex3f(0,20,0);

		//z
		glColor3f(0,0,1);
		glVertex3f(0,0,-20);
		glVertex3f(0,0,20);
		

	glEnd();
	*/


    //sun
	glPushMatrix();
	glColor3f(1,1,1);
	glLightfv(GL_LIGHT0,GL_POSITION,lightPos);
	glDisable(GL_LIGHTING);
	glBindTexture(GL_TEXTURE_2D, textureObjects[0]);//Sun Texture
	//gluSphere(planetQuad,SUN_DIAMETER*SCALE,100,100);
	gltDrawSphere(SUN_DIAMETER*SCALE,100,100);
	glEnable(GL_LIGHTING);
	glPopMatrix();
	

	//Mercury
	MercuryOrbit = fmodf(MercuryOrbit + EARTH_DEGREES_PER_SECOND/MERCURY_ORBIT_PERIOD, 360);
	MercurySpin = fmodf(MercurySpin + EARTH_DEGREES_PER_SECOND/MERCURY_ORBIT_PERIOD, 360);//Mercury Spin Setup
	glPushMatrix();
	glColor3f(1,1,1);
	glRotated(MERCURY_INCLINATION,0,0,1);//Inclination
	glRotated(MercuryOrbit,0,1,0);
	glTranslatef(MERCURY_ORBIT_RADIUS*AU,0,0);
	glBindTexture(GL_TEXTURE_2D, textureObjects[1]);//Mercury Texture
	glRotatef(MERCURY_TILT,1,0,0);
	glRotatef(MercurySpin,0,1,0);
	glRotatef(-90,1,0,0);
	gltDrawSphere(MERCURY_DIAMETER*SCALE,200,200);
	glPopMatrix();

	
	//Mercury Ring
	glPushMatrix();
	glDisable(GL_LIGHTING);
	glColor3f(MERCURY_COLOR);
	//glTranslatef(MERCURY_ORBIT_RADIUS*DISTANCE,0,0);
	glRotated(MERCURY_INCLINATION,0,0,1);//Inclination
	glRotated(90,1,0,0);
	gluDisk(orbitQuad,MERCURY_ORBIT_RADIUS*AU,MERCURY_ORBIT_RADIUS*AU,100,180);
	glEnable(GL_LIGHTING);
	glPopMatrix();


	
	//Venus
	VenusOrbit = fmodf(VenusOrbit + EARTH_DEGREES_PER_SECOND/VENUS_ORBIT_PERIOD, 360);
	VenusSpin = fmodf(VenusSpin + EARTH_DEGREES_PER_SECOND/VENUS_ORBIT_PERIOD, 360);//Venus Spin Setup
	glPushMatrix();
	glColor3f(1,1,1);
	glRotated(VENUS_INCLINATION,0,0,1);//Inclination
	glRotated(VenusOrbit,0,1,0);
	glTranslatef(VENUS_ORBIT_RADIUS*AU,0,0);
	glBindTexture(GL_TEXTURE_2D, textureObjects[2]);//Venus Texture
	glRotatef(VENUS_TILT,1,0,0);
	glRotatef(VenusSpin,0,1,0);
	glRotatef(-90,1,0,0);
	gltDrawSphere(VENUS_DIAMETER*SCALE,200,200);
	glPopMatrix();

	//Venus Ring
	glPushMatrix();
	glDisable(GL_LIGHTING);
	glColor3f(VENUS_COLOR);
	//glTranslatef(VENUS_ORBIT_RADIUS*DISTANCE,0,0);
	glRotated(VENUS_INCLINATION,0,0,1);//Inclination
	glRotated(90,1,0,0);
	gluDisk(orbitQuad,VENUS_ORBIT_RADIUS*AU,VENUS_ORBIT_RADIUS*AU,100,180);
	glEnable(GL_LIGHTING);
	glPopMatrix();

	
	//Earth
	EarthOrbit = fmodf(EarthOrbit + EARTH_DEGREES_PER_SECOND, 360);
	EarthSpin = fmodf(EarthSpin + EARTH_DEGREES_PER_SECOND, 360);//Earth Spin Setup
	glPushMatrix();
	glColor3f(1,1,1);

	glRotated(EARTH_INCLINATION,0,0,1);//Inclination
	glRotated(EarthOrbit,0,1,0);
	glTranslatef(EARTH_ORBIT_RADIUS*AU,0,0);
	glBindTexture(GL_TEXTURE_2D, textureObjects[3]);//Earth Texture
	glPushMatrix();
	glRotatef(EARTH_TILT,1,0,0);
	glRotatef(EarthSpin,0,1,0);
	glRotatef(-90,1,0,0);
	gltDrawSphere(EARTH_DIAMETER*SCALE,200,200);
	glPopMatrix();
	
	//Moon
	MoonOrbit = fmodf(MoonOrbit + EARTH_DEGREES_PER_SECOND/MOON_ORBIT_RADIUS*AU, 360);
	glPushMatrix();
	glColor3f(1,1,1);
	glRotated(MOON_INCLINATION,0,0,1);//Inclination
	glRotated(MoonOrbit,0,1,0);
	glTranslatef(MOON_ORBIT_RADIUS*AU,0,0);
	glBindTexture(GL_TEXTURE_2D, textureObjects[4]);//Moon Texture
	gltDrawSphere(MOON_DIAMETER*SCALE,200,200);
	glPopMatrix();
	glPopMatrix();
	

	//Earth Ring
	glPushMatrix();
	glDisable(GL_LIGHTING);
	glColor3f(EARTH_COLOR);
	glRotated(EARTH_INCLINATION,0,0,1);//Inclination
	glRotated(90,1,0,0);
	gluDisk(orbitQuad,EARTH_ORBIT_RADIUS*AU,EARTH_ORBIT_RADIUS*AU,100,180);
	glEnable(GL_LIGHTING);
	glPopMatrix();


	//Mars
	MarsOrbit = fmodf(MarsOrbit + EARTH_DEGREES_PER_SECOND/MARS_ORBIT_PERIOD, 360);
	MarsSpin = fmodf(MarsSpin + EARTH_DEGREES_PER_SECOND/MARS_ORBIT_PERIOD, 360);//Mars Spin Setup
	glPushMatrix();
	glColor3f(1,1,1);
	glRotated(MARS_INCLINATION,0,0,1);//Inclination
	glRotated(MarsOrbit,0,1,0);
	glTranslatef(MARS_ORBIT_RADIUS*AU,0,0);
	glBindTexture(GL_TEXTURE_2D, textureObjects[5]);//Mars Texture
	glRotatef(MARS_TILT,1,0,0);
	glRotatef(MarsSpin,0,1,0);
	glRotatef(-90,1,0,0);
	gltDrawSphere(MARS_DIAMETER*SCALE,200,200);
	glPopMatrix();

	//Mars Ring
	glPushMatrix();
	glDisable(GL_LIGHTING);
	glColor3f(MARS_COLOR);
	glRotated(MARS_INCLINATION,0,0,1);//Inclination
	glRotated(90,1,0,0);
	gluDisk(orbitQuad,MARS_ORBIT_RADIUS*AU,MARS_ORBIT_RADIUS*AU,100,180);
	glEnable(GL_LIGHTING);
	glPopMatrix();


	
	//Jupiter
	JupiterOrbit = fmodf(JupiterOrbit + EARTH_DEGREES_PER_SECOND/JUPITER_ORBIT_PERIOD, 360);
	JupiterSpin = fmodf(JupiterSpin + EARTH_DEGREES_PER_SECOND/JUPITER_ORBIT_PERIOD, 360);//Jupiter Spin Setup
	glPushMatrix();
	glColor3f(1,1,1);
	glRotated(JUPITER_INCLINATION,0,0,1);//Inclination
	glRotated(JupiterOrbit,0,1,0);
	glTranslatef(JUPITER_ORBIT_RADIUS*AU,0,0);
	glBindTexture(GL_TEXTURE_2D, textureObjects[6]);//Jupiter Texture
	glRotatef(JUPITER_TILT,1,0,0);
	glRotatef(JupiterSpin,0,1,0);
	glRotatef(-90,1,0,0);
	gltDrawSphere(JUPITER_DIAMETER*SCALE,200,200);
	glPopMatrix();

	//Jupiter Ring
	glPushMatrix();
	glDisable(GL_LIGHTING);
	glColor3f(JUPITER_COLOR);
	glRotated(JUPITER_INCLINATION,0,0,1);//Inclination
	glRotated(90,1,0,0);
	gluDisk(orbitQuad,JUPITER_ORBIT_RADIUS*AU,JUPITER_ORBIT_RADIUS*AU,100,180);
	glEnable(GL_LIGHTING);
	glPopMatrix();


	
	//Saturn
	SaturnOrbit = fmodf(SaturnOrbit + EARTH_DEGREES_PER_SECOND/SATURN_ORBIT_PERIOD, 360);
	SaturnSpin = fmodf(SaturnSpin + EARTH_DEGREES_PER_SECOND/SATURN_ORBIT_PERIOD, 360);//Saturn Spin Setup
	glPushMatrix();
	glColor3f(1,1,1);
	glRotated(SATURN_INCLINATION,0,0,1);//Inclination
	glRotated(SaturnOrbit,0,1,0);
	glTranslatef(SATURN_ORBIT_RADIUS*AU,0,0);
	glBindTexture(GL_TEXTURE_2D, textureObjects[7]);//Saturn Texture
	glRotatef(SATURN_TILT,1,0,0);
	glRotatef(SaturnSpin,0,1,0);
	glRotatef(-90,1,0,0);
	gltDrawSphere(SATURN_DIAMETER*SCALE,200,200);
	glPopMatrix();

	//Saturn Ring
	glPushMatrix();
	glDisable(GL_LIGHTING);
	glColor3f(SATURN_COLOR);
	glRotated(SATURN_INCLINATION,0,0,1);//Inclination
	glRotated(90,1,0,0);
	gluDisk(orbitQuad,SATURN_ORBIT_RADIUS*AU,SATURN_ORBIT_RADIUS*AU,100,180);
	glEnable(GL_LIGHTING);
	glPopMatrix();

	
	//Uranus
	UranusOrbit = fmodf(UranusOrbit + EARTH_DEGREES_PER_SECOND/URANUS_ORBIT_PERIOD, 360);
	UranusSpin = fmodf(UranusSpin + EARTH_DEGREES_PER_SECOND/URANUS_ORBIT_PERIOD, 360);//Uranus Spin Setup
	glPushMatrix();
	glColor3f(1,1,1);
	glRotated(URANUS_INCLINATION,0,0,1);//Inclination
	glRotated(UranusOrbit,0,1,0);
	glTranslatef(URANUS_ORBIT_RADIUS*AU,0,0);
	glBindTexture(GL_TEXTURE_2D, textureObjects[8]);//Uranus Texture
	glRotatef(URANUS_TILT,1,0,0);
	glRotatef(UranusSpin,0,1,0);
	glRotatef(-90,1,0,0);
	gltDrawSphere(URANUS_DIAMETER*SCALE,200,200);
	glPopMatrix();

	//Uranus Ring
	glPushMatrix();
	glDisable(GL_LIGHTING);
	glColor3f(URANUS_COLOR);
	glRotated(URANUS_INCLINATION,0,0,1);//Inclination
	glRotated(90,1,0,0);
	gluDisk(orbitQuad,URANUS_ORBIT_RADIUS*AU,URANUS_ORBIT_RADIUS*AU,100,180);
	glEnable(GL_LIGHTING);
	glPopMatrix();


	
	//Neptune
	NeptuneOrbit = fmodf(NeptuneOrbit + EARTH_DEGREES_PER_SECOND/NEPTUNE_ORBIT_PERIOD, 360);
	NeptuneSpin = fmodf(NeptuneSpin + EARTH_DEGREES_PER_SECOND/NEPTUNE_ORBIT_PERIOD, 360);//Neptune Spin Setup
	glPushMatrix();
    glColor3f(1,1,1);
	glRotated(NEPTUNE_INCLINATION,0,0,1);//Inclination
	glRotated(NeptuneOrbit,0,1,0);
	glTranslatef(NEPTUNE_ORBIT_RADIUS*AU,0,0);
	glBindTexture(GL_TEXTURE_2D, textureObjects[9]);//Neptune Texture
	glRotatef(NEPTUNE_TILT,1,0,0);
	glRotatef(NeptuneSpin,0,1,0);
	glRotatef(-90,1,0,0);
	gltDrawSphere(NEPTUNE_DIAMETER*SCALE,200,200);
	glPopMatrix();

	//Neptune Ring
	glPushMatrix();
	glDisable(GL_LIGHTING);
	glColor3f(NEPTUNE_COLOR);
	glRotated(NEPTUNE_INCLINATION,0,0,1);//Inclination
	glRotated(90,1,0,0);
	gluDisk(orbitQuad,NEPTUNE_ORBIT_RADIUS*AU,NEPTUNE_ORBIT_RADIUS*AU,100,180);
	glEnable(GL_LIGHTING);
	glPopMatrix();
	

	// Flush drawing commands
	glutSwapBuffers();
	glutPostRedisplay();
}

void TimerFunction(int value)
    {
		 // Redraw the scene with new coordinates
		glutPostRedisplay();
		glutTimerFunc(16,TimerFunction, 1);
    }

///////////////////////////////////////////////////////////
// Setup the rendering context
void SetupRC(void)
{
	  GLbyte *pBytes;
    GLint iWidth, iHeight, iComponents;
    GLenum eFormat;
	lookUp=false;
	lookDown=false;
	lookLeft=false;
	lookRight=false;
	walkForward=false;
	walkBackward=false;
	strafeLeft=false;
	strafeRight=false;
	yRotationAngle=0;
	xRotationAngle=0;
	zRotationAngle=0;
	xTranslation=0;
	yTranslation=0;
	zTranslation=0;


	// White background
	glClearColor(0.0f, 0.0f, 0.0f, 1.0f );

	// Set drawing color to green
	glColor3f(0.0f, 1.0f, 0.0f);

	// Set color shading model to flat
	//glShadeModel(GL_FLAT);
	glShadeModel(GL_SMOOTH);
	glEnable(GL_RESCALE_NORMAL);

	// Clock wise wound polygons are front facing, this is reversed
	// because we are using triangle fans
	glFrontFace(GL_CCW);


	 glEnable (GL_DEPTH_TEST);

	 // Enable lighting
    glEnable(GL_LIGHTING);

    // Setup and enable light 0
    // Supply a slight ambient light so the objects can be seen
    glLightModelfv(GL_LIGHT_MODEL_AMBIENT, ambientLight);
	
    // The light is composed of just a diffuse and specular components
    glLightfv(GL_LIGHT0,GL_DIFFUSE,diffuse);
    glLightfv(GL_LIGHT0,GL_SPECULAR,specular);
    glLightfv(GL_LIGHT0,GL_POSITION,lightPos);

    // Enable this light in particular
    glEnable(GL_LIGHT0);


	// All materials hereafter have full specular reflectivity
    // with a high shine
 
	glMaterialfv(GL_FRONT, GL_SPECULAR,specref);
	glMaterialfv(GL_FRONT, GL_DIFFUSE,diffuseref);
	glMaterialfv(GL_FRONT, GL_AMBIENT,ambientref);

	//changes alpha, greater the alpha, higher the intensity and smaller the highlights
    glMateriali(GL_FRONT, GL_SHININESS,128);
	glTexParameteri(GL_TEXTURE_2D, GL_GENERATE_MIPMAP, GL_TRUE);

	 // Load texture
	glEnable(GL_TEXTURE_2D);
	glGenTextures(NUM_TEXTURES, textureObjects);


	//load sun.tga, BIND TO the GL_TEXTURE_2D target. 
	glBindTexture(GL_TEXTURE_2D, textureObjects[0]);
    pBytes = gltLoadTGA("sun.tga", &iWidth, &iHeight, &iComponents, &eFormat);
	/*
    gluBuild2DMipmaps(GL_TEXTURE_2D, iComponents, iWidth, iHeight, eFormat, GL_UNSIGNED_BYTE, pBytes);
	free(pBytes);
	*/
	glTexImage2D(GL_TEXTURE_2D, 0, iComponents, iWidth, iHeight, 0, eFormat, GL_UNSIGNED_BYTE, pBytes);
	free(pBytes);
	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_CLAMP_TO_EDGE);
	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_CLAMP_TO_EDGE);
	glTexEnvi(GL_TEXTURE_ENV, GL_TEXTURE_ENV_MODE, GL_MODULATE);

	//load mercury.tga
	glBindTexture(GL_TEXTURE_2D, textureObjects[1]);
	pBytes = gltLoadTGA("mercury.tga", &iWidth, &iHeight, &iComponents, &eFormat);
    glTexImage2D(GL_TEXTURE_2D, 0, iComponents, iWidth, iHeight, 0, eFormat, GL_UNSIGNED_BYTE, pBytes);
	free(pBytes);
	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_CLAMP_TO_EDGE);
	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_CLAMP_TO_EDGE);
	glTexEnvi(GL_TEXTURE_ENV, GL_TEXTURE_ENV_MODE, GL_MODULATE);

	//load venus.tga
	glBindTexture(GL_TEXTURE_2D, textureObjects[2]);
	pBytes = gltLoadTGA("venus.tga", &iWidth, &iHeight, &iComponents, &eFormat);
    glTexImage2D(GL_TEXTURE_2D, 0, iComponents, iWidth, iHeight, 0, eFormat, GL_UNSIGNED_BYTE, pBytes);
	free(pBytes);
	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_CLAMP_TO_EDGE);
	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_CLAMP_TO_EDGE);
	glTexEnvi(GL_TEXTURE_ENV, GL_TEXTURE_ENV_MODE, GL_MODULATE);

	//load earth.tga
	glBindTexture(GL_TEXTURE_2D, textureObjects[3]);
	pBytes = gltLoadTGA("earth.tga", &iWidth, &iHeight, &iComponents, &eFormat);
    glTexImage2D(GL_TEXTURE_2D, 0, iComponents, iWidth, iHeight, 0, eFormat, GL_UNSIGNED_BYTE, pBytes);
	free(pBytes);
	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_CLAMP_TO_EDGE);
	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_CLAMP_TO_EDGE);
	glTexEnvi(GL_TEXTURE_ENV, GL_TEXTURE_ENV_MODE, GL_MODULATE);

	//load moon.tga
	glBindTexture(GL_TEXTURE_2D, textureObjects[4]);
	pBytes = gltLoadTGA("moon.tga", &iWidth, &iHeight, &iComponents, &eFormat);
    glTexImage2D(GL_TEXTURE_2D, 0, iComponents, iWidth, iHeight, 0, eFormat, GL_UNSIGNED_BYTE, pBytes);
	free(pBytes);
	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_CLAMP_TO_EDGE);
	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_CLAMP_TO_EDGE);
	glTexEnvi(GL_TEXTURE_ENV, GL_TEXTURE_ENV_MODE, GL_MODULATE);

	//load mars.tga
	glBindTexture(GL_TEXTURE_2D, textureObjects[5]);
	pBytes = gltLoadTGA("mars.tga", &iWidth, &iHeight, &iComponents, &eFormat);
    glTexImage2D(GL_TEXTURE_2D, 0, iComponents, iWidth, iHeight, 0, eFormat, GL_UNSIGNED_BYTE, pBytes);
	free(pBytes);
	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_CLAMP_TO_EDGE);
	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_CLAMP_TO_EDGE);
	glTexEnvi(GL_TEXTURE_ENV, GL_TEXTURE_ENV_MODE, GL_MODULATE);

	//load jupiter.tga
	glBindTexture(GL_TEXTURE_2D, textureObjects[6]);
	pBytes = gltLoadTGA("jupiter.tga", &iWidth, &iHeight, &iComponents, &eFormat);
    glTexImage2D(GL_TEXTURE_2D, 0, iComponents, iWidth, iHeight, 0, eFormat, GL_UNSIGNED_BYTE, pBytes);
	free(pBytes);
	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_CLAMP_TO_EDGE);
	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_CLAMP_TO_EDGE);
	glTexEnvi(GL_TEXTURE_ENV, GL_TEXTURE_ENV_MODE, GL_MODULATE);

	//load saturn.tga
	glBindTexture(GL_TEXTURE_2D, textureObjects[7]);
	pBytes = gltLoadTGA("saturn.tga", &iWidth, &iHeight, &iComponents, &eFormat);
    glTexImage2D(GL_TEXTURE_2D, 0, iComponents, iWidth, iHeight, 0, eFormat, GL_UNSIGNED_BYTE, pBytes);
	free(pBytes);
	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_CLAMP_TO_EDGE);
	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_CLAMP_TO_EDGE);
	glTexEnvi(GL_TEXTURE_ENV, GL_TEXTURE_ENV_MODE, GL_MODULATE);

	//load uranus.tga
	glBindTexture(GL_TEXTURE_2D, textureObjects[8]);
	pBytes = gltLoadTGA("uranus.tga", &iWidth, &iHeight, &iComponents, &eFormat);
    glTexImage2D(GL_TEXTURE_2D, 0, iComponents, iWidth, iHeight, 0, eFormat, GL_UNSIGNED_BYTE, pBytes);
	free(pBytes);
	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_CLAMP_TO_EDGE);
	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_CLAMP_TO_EDGE);
	glTexEnvi(GL_TEXTURE_ENV, GL_TEXTURE_ENV_MODE, GL_MODULATE);

	//load neptune.tga
	glBindTexture(GL_TEXTURE_2D, textureObjects[9]);
	pBytes = gltLoadTGA("neptune.tga", &iWidth, &iHeight, &iComponents, &eFormat);
    glTexImage2D(GL_TEXTURE_2D, 0, iComponents, iWidth, iHeight, 0, eFormat, GL_UNSIGNED_BYTE, pBytes);
	free(pBytes);
	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_CLAMP_TO_EDGE);
	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_CLAMP_TO_EDGE);
	glTexEnvi(GL_TEXTURE_ENV, GL_TEXTURE_ENV_MODE, GL_MODULATE);
	



	glTexParameteri(GL_TEXTURE_CUBE_MAP, GL_GENERATE_MIPMAP, GL_TRUE);
	    // Load Cube Map images
    for(int i = 0; i < 6; i++)
        {        
        // Load this texture map
        
        pBytes = gltLoadTGA(szCubeFaces[i], &iWidth, &iHeight, &iComponents, &eFormat);
		//gluBuild2DMipmaps(cube[i], iComponents, iWidth, iHeight, eFormat, GL_UNSIGNED_BYTE, pBytes);
        glTexImage2D(cube[i], 0, iComponents, iWidth, iHeight, 0, eFormat, GL_UNSIGNED_BYTE, pBytes);
        free(pBytes);
        }


	 // Set up texture maps        
    glTexParameteri(GL_TEXTURE_CUBE_MAP, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
    glTexParameteri(GL_TEXTURE_CUBE_MAP, GL_TEXTURE_MIN_FILTER, GL_LINEAR_MIPMAP_LINEAR);
	glTexParameteri(GL_TEXTURE_CUBE_MAP, GL_TEXTURE_WRAP_S, GL_CLAMP_TO_EDGE);
    glTexParameteri(GL_TEXTURE_CUBE_MAP, GL_TEXTURE_WRAP_T, GL_CLAMP_TO_EDGE);
    glTexParameteri(GL_TEXTURE_CUBE_MAP, GL_TEXTURE_WRAP_R, GL_CLAMP_TO_EDGE);        
    
    glTexEnvi(GL_TEXTURE_ENV, GL_TEXTURE_ENV_MODE, GL_MODULATE);

    // Enable color tracking
    glEnable(GL_COLOR_MATERIAL);
	
    // Set Material properties to follow glColor values
    glColorMaterial(GL_FRONT, GL_AMBIENT_AND_DIFFUSE);

    // All materials hereafter have full specular reflectivity
    // with a high shine
    glMaterialfv(GL_FRONT, GL_SPECULAR,specref);
    glMateriali(GL_FRONT, GL_SHININESS,128);


	
}

void ChangeSize(int w, int h)
	{
	//GLfloat nRange = 100.0f;

	// Prevent a divide by zero
	if(h == 0)
		h = 1;

	// Set Viewport to window dimensions
    glViewport(0, 0, w, h);

	// Reset projection matrix stack
	glMatrixMode(GL_PROJECTION);
	glLoadIdentity();

	// Establish clipping volume (left, right, bottom, top, near, far)
   
	gluPerspective(45,(float)w/(float)h,1,1000);

	
	// Reset Model view matrix stack
	glMatrixMode(GL_MODELVIEW);
	glLoadIdentity();

	}

// Respond to arrow keys by moving the camera frame of reference
void SpecialKeys(int key, int x, int y)
    {
    if(key == GLUT_KEY_UP)
        lookUp=true;

    if(key == GLUT_KEY_DOWN)
		lookDown=true;

    if(key == GLUT_KEY_LEFT)
		lookLeft=true;
	   
    if(key == GLUT_KEY_RIGHT)
		lookRight=true;
                        
    // Refresh the Window
    glutPostRedisplay();
    }
void SpecialKeysUp(int key, int x, int y)
    {
    if(key == GLUT_KEY_UP)
        lookUp=false;

    if(key == GLUT_KEY_DOWN)
		lookDown=false;

    if(key == GLUT_KEY_LEFT)
		lookLeft=false;
	   
    if(key == GLUT_KEY_RIGHT)
		lookRight=false;
                        
    // Refresh the Window
    glutPostRedisplay();
    }

void keyboardFunc(unsigned char key, int x, int y)
{

	switch(key)
	{
	case 'w':
		walkForward=true;
			break;
	case 's':
		walkBackward=true;
			break;
	case 'a':
		strafeLeft=true;
			break;
	case 'd':
		strafeRight=true;
			break;
	default:
			break;
	}

}

void keyboardUpFunc(unsigned char key, int x, int y)
{
	switch(key)
	{
	case 'w':
		walkForward=false;
			break;
	case 's':
		walkBackward=false;
			break;
	case 'a':
		strafeLeft=false;
			break;
	case 'd':
		strafeRight=false;
			break;
	default:
			break;
	}
		

}


///////////////////////////////////////////////////////////
// Main program entry point
int main(int argc, char* argv[])
{
	glutInit(&argc, argv);
	glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGB | GLUT_DEPTH);
	glutInitWindowSize(500,500); 
 	glutCreateWindow("Assignment 3");
	glutReshapeFunc(ChangeSize);
	glutDisplayFunc(RenderScene);
	glutTimerFunc(16, TimerFunction, 1);
	glutSpecialFunc(SpecialKeys);
	glutSpecialUpFunc(SpecialKeysUp);
	glutKeyboardUpFunc(keyboardUpFunc);
	glutKeyboardFunc(keyboardFunc);
	//glutPassiveMotionFunc(mouseCam);

	SetupRC();
	
	glutMainLoop();
    
    return 0;
}
