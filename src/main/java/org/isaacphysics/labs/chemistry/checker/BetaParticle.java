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

/**
 * Instance of a beta particle for nuclear physics.
 * Created by Ryan on 20/06/2016.
 */
public final class BetaParticle extends SpecialNuclear {

    private static final int RealMass = 0;
    private static final int RealAtom = -1;

    /**
     * Constructor method of BetaParticle.
     *
     * @param mass Mass number inputted by user.
     * @param atom Atom number inputted by user.
     */
    public BetaParticle(final Integer mass, final Integer atom) {
        super(RealMass, RealAtom, mass, atom, -1, "Beta particle", "betaparticle", "&#946;");
    }

    @Override
    public boolean equals(final Object o) {
        if (!(o instanceof BetaParticle)) {
            return false;
        }

        BetaParticle p = (BetaParticle) o;
        return p.getAtomicNumber().equals(getAtomicNumber()) && p.getMassNumber().equals(getMassNumber());
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }
}
