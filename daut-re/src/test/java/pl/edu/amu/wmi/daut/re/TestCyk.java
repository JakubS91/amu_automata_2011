package pl.edu.amu.wmi.daut.re;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import junit.framework.TestCase;

/**
 * Test klasy Cyl.
 */
public class TestCyk extends TestCase {
    private HashMap<String, GrammarNonterminalSymbol> ntSymbol = new HashMap<String,
            GrammarNonterminalSymbol>();
    private HashMap<String, GrammarTerminalSymbol> tSymbol = new HashMap<String,
            GrammarTerminalSymbol>();
    private List<GrammarRule> rules = new ArrayList<GrammarRule>();
    private List<GrammarTerminalSymbol> word = new ArrayList<GrammarTerminalSymbol>();
    /**
     * Generowanie symobli terminalnych i nieterminalnych.
     */
    private void generateSymobols() {
        ntSymbol.put("S", new GrammarNonterminalSymbol('S'));
        ntSymbol.put("A", new GrammarNonterminalSymbol('A'));
        ntSymbol.put("B", new GrammarNonterminalSymbol('B'));
        ntSymbol.put("C", new GrammarNonterminalSymbol('C'));
        tSymbol.put("a", new GrammarTerminalSymbol('a'));
        tSymbol.put("b", new GrammarTerminalSymbol('b'));
    }
    /**
     * Pierwszy test klasy Cyk.
     */
    public final void testCyk1() {
        generateSymobols();
        rules.clear();
        word.clear();
        rules.add(new GrammarRule(ntSymbol.get("S"), ntSymbol.get("A"), ntSymbol.get("C")));
        rules.add(new GrammarRule(ntSymbol.get("C"), ntSymbol.get("S"), ntSymbol.get("B")));
        rules.add(new GrammarRule(ntSymbol.get("S"), ntSymbol.get("A"), ntSymbol.get("B")));
        rules.add(new GrammarRule(ntSymbol.get("A"), tSymbol.get("a")));
        rules.add(new GrammarRule(ntSymbol.get("B"), tSymbol.get("b")));
        Cyk cyk = new Cyk(new Grammar(rules, ntSymbol.get("S")));
        word.add(tSymbol.get("a"));
        word.add(tSymbol.get("a"));
        word.add(tSymbol.get("b"));
        word.add(tSymbol.get("b"));
        assertTrue(cyk.accepts(word));
    }
    /**
     * Drugi test klasy Cyk.
     */
    public final void testCyk2() {
        generateSymobols();
        rules.clear();
        word.clear();
        rules.add(new GrammarRule(ntSymbol.get("S"), ntSymbol.get("A"), ntSymbol.get("B")));
        rules.add(new GrammarRule(ntSymbol.get("S"), ntSymbol.get("B"), ntSymbol.get("C")));
        rules.add(new GrammarRule(ntSymbol.get("A"), ntSymbol.get("B"), ntSymbol.get("A")));
        rules.add(new GrammarRule(ntSymbol.get("A"), tSymbol.get("a")));
        rules.add(new GrammarRule(ntSymbol.get("B"), ntSymbol.get("C"), ntSymbol.get("C")));
        rules.add(new GrammarRule(ntSymbol.get("B"), tSymbol.get("b")));
        rules.add(new GrammarRule(ntSymbol.get("C"), ntSymbol.get("A"), ntSymbol.get("B")));
        rules.add(new GrammarRule(ntSymbol.get("C"), tSymbol.get("a")));
        Cyk cyk = new Cyk(new Grammar(rules, ntSymbol.get("S")));
        word.add(tSymbol.get("a"));
        word.add(tSymbol.get("b"));
        word.add(tSymbol.get("a"));
        word.add(tSymbol.get("b"));
        assertTrue(cyk.accepts(word));
    }
}
