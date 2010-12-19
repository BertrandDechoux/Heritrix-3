package org.archive.modules.acceptrules.composed;

import org.archive.modules.CrawlURI;
import org.archive.modules.acceptrules.AcceptRule;
import org.archive.modules.acceptrules.KeyedPropertiesObject;
import org.archive.modules.deciderules.DecideResult;

/**
 * Rule which applies the configured decision only if a 
 * test evaluates to true.
 *
 * @author gojomo
 */
public final class PredicatedDecideRule extends KeyedPropertiesObject implements DecideRule {
    
    private final AcceptRule acceptRule;
    
    {
        setDecision(DecideResult.ACCEPT);
    }
    public DecideResult getDecision() {
        return (DecideResult) kp.get("decision");
    }
    public void setDecision(DecideResult decision) {
        kp.put("decision",decision);
    }
    
    public PredicatedDecideRule(final AcceptRule acceptRule) {
        this.acceptRule = acceptRule;
    }

    @Override
    public DecideResult decisionFor(CrawlURI uri) {
        DecideResult decideResult = getDecision();
        // test for NONE in order to avoid the potential cost of the accepts method
        if (decideResult != DecideResult.NONE && acceptRule.accepts(uri)) {
            return decideResult;
        }
        return DecideResult.NONE;
    }

}
