/**
 * Copyright 2016 Ryan Lau
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 *
 * You may obtain a copy of the License at
 * 		http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.isaacphysics.labs.chemistry.checker;

import java.util.HashMap;

/**
 * Special class of Formula that only cares about electrons in chemical equations.
 *
 * Created by Ryan on 17/06/2016.
 */
public final class ChemicalElectron extends Formula {

    private static final int Charge = -1;
    private static final Fraction ChargeFrac = new Fraction(Charge, 1);

    /**
     * Saved atom count.
     */
    private static HashMap<String, Fraction> savedAtomCount = new HashMap<>();

    /**
     * Constructor function of ChemicalElectron.
     */
    public ChemicalElectron() {
        super();
    }

    @Override
    public boolean equals(final Object o) {
        return o instanceof ChemicalElectron;
    }

    @Override
    public String toString() {
        return "e^{-}";
    }

    @Override
    public Integer getAtomicNumber() throws NuclearException {
        throw new NuclearException("Atomic number undefined for ChemicalElectron.");
    }

    @Override
    public Integer getMassNumber() throws NuclearException {
        throw new NuclearException("Mass number undefined for ChemicalElectron.");
    }

    @Override
    public Fraction getCharge() {
        return ChargeFrac;
    }

    @Override
    public HashMap<String, Fraction> getAtomCount() {
        return savedAtomCount;
    }

    @Override
    public String getDotId() {
        return "electron_" + getdotId();
    }

    @Override
    public String getDotCode() {
        return "\t"
                + getDotId()
                + " [label=\"{&zwj;&zwj;&zwj;&zwj;PhysicalElectron&zwnj;|\\n"
                + getDotString()
                + "\n\n}\",color=\"#4c7fbe\"];\n";
    }

    @Override
    public String getDotString() {
        return "e&zwj;&zwj;-&zwnj;";
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }
}
