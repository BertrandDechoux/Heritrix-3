package org.archive.modules.acceptrules.composed;

import org.archive.modules.CrawlURI;
import org.archive.modules.acceptrules.AcceptRule;
import org.archive.modules.deciderules.DecideResult;


/**
 * Convertor for {@link DecideRule} to {@link AcceptRule}.
 * 
 * @author Bertrand Dechoux
 */
public class DecideRuleAsAcceptRule implements AcceptRule {
    private static final long serialVersionUID = 1L;
    
    private final DecideRule decideRule;
    private final boolean acceptsNONE;
    
    public DecideRuleAsAcceptRule(final DecideRule decideRule, final boolean acceptsNONE) {
        this.decideRule = decideRule;
        this.acceptsNONE = acceptsNONE;
    }

    @Override
    public boolean accepts(CrawlURI uri) {
        DecideResult decideResult = decideRule.decisionFor(uri);
        if(decideResult == DecideResult.NONE) {
            return acceptsNONE;
        }
        if(decideResult == DecideResult.ACCEPT) {
            return true;
        }
        return false;
        
    }

}
