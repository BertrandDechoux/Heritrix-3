package org.archive.modules.acceptrules;

import java.io.Serializable;

import org.archive.modules.CrawlURI;

/**
 * Take a binary decision about whether a particular {@link CrawlURI} should be
 * used for a process or not.
 * 
 * @author Bertrand Dechoux
 */
public interface AcceptRule extends Serializable {

    boolean accepts(CrawlURI uri);

}