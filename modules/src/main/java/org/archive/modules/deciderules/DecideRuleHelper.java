package org.archive.modules.deciderules;

import java.util.Arrays;

import org.archive.modules.acceptrules.AcceptRule;

/**
 * Helper class currently only helping to locate classes which used {@link DecideRule}
 * in a non consistent way. That is considering {@link DecideResult#NONE} as {@link DecideResult#ACCEPT}.
 * 
 * @author Bertrand Dechoux
 */
public final class DecideRuleHelper {

    /**
     * This a helper class that should not be instantiated. All methods should
     * be static.
     */
    private DecideRuleHelper() {
    }

    /**
     * In order to be compatible with previous configurations, we have to make
     * sure that {@link DecideResult#NONE} is handled like before, even though
     * users of {@link AcceptRule} should not be anymore aware of its existence.
     * All classes impacted by this change are easy to track because they should
     * all call this method.
     */
    public static AcceptRule getBackardCompatibleRule(AcceptRule rule) {
        if (rule instanceof DecideRuleSequence) {
            DecideRuleSequence compatibilityRule = new DecideRuleSequence();
            compatibilityRule.setRules(Arrays.asList(new AcceptDecideRule(),
                    (DecideRule) rule));
            rule = compatibilityRule;
        }
        return rule;
    }

}
