package org.archive.modules.acceptrules.composed;

import org.archive.modules.CrawlURI;
import org.archive.modules.acceptrules.AcceptRule;
import org.archive.modules.acceptrules.KeyedPropertiesObject;

/**
 * Decorator for deactivating an existent {@link AcceptRule} implementation. The
 * deactivation of the rule is amenable to sheet-based contextual overriding.
 * 
 * @author Bertrand Dechoux
 */
public final class DeactivateAcceptRule extends KeyedPropertiesObject implements AcceptRule {
    private static final long serialVersionUID = 1L;

    private final AcceptRule decoratedRule;
    private boolean defaultAcceptsResult = true;

    /**
     * @param decoratedRule
     *            rule that should be deactivated
     */
    public DeactivateAcceptRule(final AcceptRule decoratedRule) {
        this.decoratedRule = decoratedRule;
        setEnabled(true);
    }

    /**
     * Negate the decorated rule.
     */
    @Override
    public boolean accepts(CrawlURI uri) {
        if (getEnabled()) {
            return !decoratedRule.accepts(uri);
        } else {
            return defaultAcceptsResult;
        }
    }

    public boolean getEnabled() {
        return (Boolean) kp.get("enabled");
    }

    public void setEnabled(boolean enabled) {
        kp.put("enabled", enabled);
    }

    public void setDefaultAcceptsResult(boolean defaultAcceptsResult) {
        this.defaultAcceptsResult = defaultAcceptsResult;
    }

    public boolean isDefaultAcceptsResult() {
        return defaultAcceptsResult;
    }

}
