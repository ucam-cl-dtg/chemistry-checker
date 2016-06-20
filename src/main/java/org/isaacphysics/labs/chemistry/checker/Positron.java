package org.isaacphysics.labs.chemistry.checker;

import java.util.HashMap;

/**
 * An instance of a positron.
 * Created by Ryan on 20/06/2016.
 */
public class Positron extends Nuclear
{
    @Override
    public Integer getMassNumber() { return 0; }

    @Override
    public Integer getAtomicNumber() { return 1; }

    @Override
    public Integer getCharge() { return 1; }

    @Override
    public HashMap<String, Integer> getAtomCount() { return new HashMap<>(); }

    @Override
    public boolean equals(Object o) { return (o instanceof Positron); }

    @Override
    public String toString() { return "/positron"; }

    @Override
    public String getDotId() { return "positron_" + dotId; }

    @Override
    public String getDotCode()
    {
        StringBuilder result = new StringBuilder();

        result.append("\t");
        result.append(getDotId());

        result.append(" [label=\"{&zwj;&zwj;&zwj;&zwj;Positron&zwnj;|\\n");
        result.append(getDotString());

        result.append("\\n\\n|&zwj;&zwj;&zwj;atomic #&zwnj;: 1");

        result.append("\\n|&zwj;&zwj;&zwj;mass #&zwnj;: 0");

        result.append("}\",color=\"#4c7fbe\"];\n");
        return result.toString();
    }

    @Override
    public String getDotString()
    {
        return "&zwj;&zwj;0&zwnj;&zwj;1&zwnj;e&zwj;&zwj;+&zwnj;";
    }
}
