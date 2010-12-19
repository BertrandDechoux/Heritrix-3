package org.archive.modules.acceptrules.composed;

import org.archive.modules.CrawlURI;
import org.archive.modules.deciderules.DecideResult;

/**
 * Rule with a three-state decision.
 * 
 * @author Bertrand Dechoux
 */
interface DecideRule {
    
    DecideResult decisionFor(CrawlURI uri);

}
