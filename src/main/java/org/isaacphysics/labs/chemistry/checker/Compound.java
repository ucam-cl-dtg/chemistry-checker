package org.isaacphysics.labs.chemistry.checker;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Ryan on 15/06/2016.
 * Compound: A chemical item with more than one kind of elements.
 */
public final class Compound extends Molecule
{
    /**
     * The groups of molecules involved in the term.
     */
    private ArrayList<Molecule> groups;

    /**
     * The number of compounds involved in this term.
     * For instance number of (HCO)3 is 3, and number of NaOH is 1.
     */
    private Integer number;

    /**
     * Constructor function of Compound.
     * @param m A molecule that is involved in the compound
     */
    public Compound(Molecule m)
    {
        super();
        groups = new ArrayList<>();

        if (m != null)
            groups.add(m);

        number = 1;
    }

    /**
     * Adds a molecule to the Compound instance.
     * @param m Molecule to be added
     */
    void add(Molecule m)
    {
        groups.add(m);
    }

    /**
     * Appends the group of molecules in another compound to this instance of Compound.
     * @param c Compound to be appended
     */
    void addCompound(Compound c)
    {
        for (Molecule m: c.groups)
        {
            groups.add(m);
        }
    }

    /**
     * Setter function. Changes number of this instance.
     * @param n New number of this instance
     */
    public void setNumber(Integer n)
    {
        number = n;
    }

    @Override
    public String toString()
    {
        StringBuilder b = new StringBuilder();

        if (number > 1)
        {
            b.append("(");
            for (Molecule m : groups)
                b.append(m.toString());
            b.append(")");
            b.append(number.toString());
        }
        else
        {
            for (Molecule m : groups)
                b.append(m.toString());
        }

        return b.toString();
    }

    @Override
    public boolean equals(Object o)
    {
        if (o instanceof Compound)
        {
            Compound other = (Compound) o;
            return this.toString().equals(other.toString());
        }
        return false;
    }

    //@Override
    //public int hashCode() {return groups.size();}

    @Override
    public HashMap<String, Integer> getAtomCount()
    {
        HashMap<String, Integer> h = new HashMap<>();
        for (Molecule m : groups)
        {
            for (String element : m.getAtomCount().keySet())
            {
                if (!h.containsKey(element))
                    h.put(element,  m.getAtomCount().get(element) * number);
                else
                    h.put(element, h.get(element) + m.getAtomCount().get(element) * number);
            }
        }
        return h;
    }

/*    public Integer getCharge()
    {
        Integer c = 0;
        for (Molecule m : groups)
            c += m.getCharge();
        return c;
    }*/

    @Override
    public String getDotId() {return "compound" + dotId;}

    @Override
    public String getDotCode()
    {
        StringBuilder result = new StringBuilder();
        result.append("\t");
        result.append(getDotId());
        result.append(" [label=\"{&zwj;&zwj;&zwj;&zwj;Compound&zwnj;|\\n");
        result.append(getDotString());
        result.append("\\n\\n|&zwj;&zwj;&zwj;number&zwnj;: ");
        result.append(number);
        result.append("\\n|&zwj;&zwj;&zwj;molecules&zwnj;}\",color=\"#944cbe\"];\n");
        for (Molecule m : groups)
        {
            result.append("\t");
            result.append(getDotId());
            result.append(":s -> ");
            result.append(m.getDotId());
            result.append(":n;\n");
            result.append(m.getDotCode());
        }
        return result.toString();
    }

    @Override
    public String getDotString()
    {
        StringBuilder b = new StringBuilder();

        if (number > 1)
        {
            b.append("(");
            for (Molecule m : groups)
                b.append(m.getDotString());
            b.append(")&zwj;");
            b.append(number.toString());
            b.append("&zwnj;");
        }
        else
        {
            for (Molecule m : groups)
                b.append(m.getDotString());
        }

        return b.toString();
    }

    @Override
    public Integer getNumber()
    {
        return number;
    }
}