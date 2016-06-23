package org.isaacphysics.labs.chemistry.checker;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Statement containing nuclear expressions.
 * Created by Ryan on 21/06/2016.
 */
public class NuclearExpressionStatement extends Statement implements Countable
{
    /**
     * Expression involved in statement
     */
    private Expression expr;

    /**
     * Constructor method of ExpressionStatement.
     * @param e Expression involved in the statement.
     */
    public NuclearExpressionStatement(Expression e) {
        expr = e;
    }

    @Override
    public String toString() {
        return expr.toString();
    }

    @Override
    public String getDotId() { return null; }

    @Override
    public boolean equals(Object o)
    {
        if (o instanceof NuclearExpressionStatement)
        {
            NuclearExpressionStatement other = (NuclearExpressionStatement) o;
            return this.expr.equals(other.expr);
        }
        return false;
    }

    @Override
    public boolean containsError() {
        return expr.containsError();
    }

    @Override
    public HashMap<String, Integer> getAtomCount() {
        return expr.getAtomCount();
    }

    @Override
    public Integer getCharge() {
        return expr.getCharge();
    }

    Expression getExpression() {
        return this.expr;
    }

    @Override
    public String getDotCode()
    {
        StringBuilder result = new StringBuilder();
        result.append("digraph chemical_syntax_tree {\n");
        result.append("\tnode [shape=record,penwidth=2,splines=ortho];\n\n");
        result.append(expr.getDotCode());
        result.append("}\n");
        return result.toString();
    }

    @Override
    public boolean weaklyEquivalent(Statement s)
    {
        if (!(s instanceof NuclearExpressionStatement))
            return false;

        NuclearExpressionStatement other = (NuclearExpressionStatement) s;

        return expr.weaklyEquivalent(other.expr);
    }

    @Override
    public String getDotString()
    {
        return null;
    }

    public boolean isValid()
    {
        return expr.isValidAtomicNumber();
    }

    /**
     * @return Sum of atomic numbers in nuclear expression.
     * @throws NuclearException
     */
    public Integer getAtomicCount() throws NuclearException
    {
        return expr.getAtomicCount();
    }

    /**
     * @return Sum of mass numbers in nuclear expression.
     * @throws NuclearException
     */
    public Integer getMassCount() throws NuclearException
    {
        return expr.getMassCount();
    }

    public ArrayList<Term> getWrongTerms(NuclearExpressionStatement e)
    {
        return expr.getWrongTerms(e.expr);
    }

    @Override
    public boolean check(Statement input)
    {
        if (!(input instanceof NuclearExpressionStatement))
        {
            // not even NuclearExpressionStatement
            System.out.println("Not a NuclearExpressionStatement!");
            return false;
        }

        if (input.containsError())
        {
            // error exists in argument
            System.out.printf("Input: %s\nPlease correct the error.\n", input.toString());
            return false;
        }

        if (equals(input))
            return true;

        NuclearExpressionStatement e_input = (NuclearExpressionStatement) input;

        if (!e_input.isValid())
        {
            // invalid atomic numbers
            System.out.println("There are elements with invalid atomic numbers.");
            return false;
        }

        if (!weaklyEquivalent(e_input))
        {
            // not weakly equivalent: exists irrelevant terms in equation
            System.out.println("Unrelated terms exist in equation.");
        }
        else
        {
            // wrong coefficients in some terms
            System.out.println("Some terms have incorrect coefficients.");
        }

        System.out.println("Wrong terms: " + getWrongTerms(e_input));
        return false;
    }
}
