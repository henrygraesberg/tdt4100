package no.ntnu.tdt4100.bytebadger.part6;

/**
 * Interface that receives updates on build status changes.
 */

public interface IBuildStatusObserver {
    void updateBuildStatus(String buildID, String status);
}
