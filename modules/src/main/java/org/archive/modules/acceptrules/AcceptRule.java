package org.archive.modules.acceptrules;

import org.archive.modules.CrawlURI;

/**
 * Take a binary decision about whether a particular {@link CrawlURI} should be
 * used for a process or not.
 * 
 * @author Bertrand Dechoux
 */
public interface AcceptRule {

    boolean accepts(CrawlURI uri);

}