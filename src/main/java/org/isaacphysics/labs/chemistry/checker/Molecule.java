/**
 * Copyright 2016 James Sharkey
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

/**
 *
 */
public abstract class Molecule extends Formula {

    /**
     * Constructor method of Molecule.
     * Does nothing, except from invoking constructor of parent.
     */
    public Molecule() {
        super();
    }

    @Override
    public Fraction getCharge() {
        return new Fraction(0, 1);
    }

    /**
     * Returns number of molecules involved.
     *
     * @return Number of molecules involved.
     */
    public abstract Integer getNumber();

    @Override
    public abstract boolean equals(Object o);

    @Override
    public Integer getMassNumber() throws NuclearException {
        throw new NuclearException("Mass number undefined for Molecule.");
    }

    @Override
    public Integer getAtomicNumber() throws NuclearException {
        throw new NuclearException("Atomic number undefined for Molecule.");
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }
}
