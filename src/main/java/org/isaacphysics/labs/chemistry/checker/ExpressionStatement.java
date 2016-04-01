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

import java.util.HashMap;

public class ExpressionStatement extends Statement implements Countable {

    Expression terms;

    public ExpressionStatement(Expression e) {
        terms=e;
    }

    public String toString() {
        return terms.toString();
    }

    public boolean equals(Object o) {
        if (o instanceof ExpressionStatement) {
            ExpressionStatement other = (ExpressionStatement) o;
            return this.terms.equals(other.terms);
        }
        return false;
    }

    public boolean containsError() {
        return terms.containsError();
    }

    public HashMap<String, Integer> getAtomCount() {
        return terms.getAtomCount();
    }

    public Integer getCharge() {
        return terms.getCharge();
    }
}
