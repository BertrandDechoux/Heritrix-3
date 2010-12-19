package org.archive.modules.acceptrules.composed;

import org.archive.modules.CrawlURI;
import org.archive.modules.acceptrules.AcceptRule;

/**
 * Decorator for negating an existent {@link AcceptRule} implementation.
 * 
 * @author Bertrand Dechoux
 */
public final class NegateAcceptRule implements AcceptRule {
    private static final long serialVersionUID = 1L;

    private final AcceptRule decoratedRule;

    /**
     * @param decoratedRule rule that should be negated
     */
    public NegateAcceptRule(final AcceptRule decoratedRule) {
        this.decoratedRule = decoratedRule;
    }

    /**
     * Negate the decorated rule.
     */
    @Override
    public boolean accepts(CrawlURI uri) {
        return !decoratedRule.accepts(uri);
    }

}
