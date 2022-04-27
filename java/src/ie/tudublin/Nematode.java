package ie.tudublin;

import processing.core.PApplet;
import processing.data.TableRow;

public class Nematode 
{
    private String name;
    private int length;
    private int limbs;
    private String gender;
    private int eyes;

    @Override
    public String toString()
    {
        return "Nematode [Name=" + name + ", length=" + length + ", limbs=" + limbs + ", gender=" + gender + ", eyes=" + eyes + "]";
    }

    public Nematode(TableRow tr)
    {
        this(tr.getString("name"), tr.getInt("length"), tr.getInt("limbs"), tr.getString("gender"), tr.getInt("eyes"));
    }
    
    public Nematode(String name, int length, int limbs, String gender, int eyes)
    {
        this.name = name;
        this.length = length;
        this.limbs = limbs;
        this.gender = gender;
        this.eyes = eyes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getLimbs() {
        return limbs;
    }

    public void setLimbs(int limbs) {
        this.limbs = limbs;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getEyes() {
        return eyes;
    }

    public void setEyes(int eyes) {
        this.eyes = eyes;
    }

    public void render(NematodeVisualiser pa)
    {
        float x = 400;
        float y = PApplet.map(getLength(), 0, 8, 200, 600);
        float firstY = 0;
        float d= 800 / getLength();

        for(int j = 0; j < getLength(); j++)
        {
            pa.stroke(255);
            pa.noFill();
            y = PApplet.map(j, 0, getLength(), d / 2, 800 - (d / 2));

            /*if(j == 0)
            {
                firstY = y;
                pa.circle(400, y, 100);
            }*/

            /*if(j > 0)
            {
                firstY += 100;
                pa.circle(400, firstY, 100);
            }*/

            pa.circle(400, y, d- (d/3));

            if(limbs == 1)
            {
                pa.line(400 - ((d- (d/3))/2), y, (400 - ((d- (d/3))/2)) - 50, y);
                pa.line(400 + ((d- (d/3))/2), y, (400 + ((d- (d/3))/2)) + 50, y);
            }

            if(eyes == 1)
            {
                if(j == 0)
                {
                    pa.line(400, y - ((d- (d/3))/2), 375, y - ((d- (d/3))/2) - 25);
                    pa.line(400, y - ((d- (d/3))/2), 425, y - ((d- (d/3))/2) - 25);
                    pa.circle(375, y - ((d- (d/3))/2) - 25, 25);
                    pa.circle(425, y - ((d- (d/3))/2) - 25, 25);
                }
            }
        }


    }

}
