package no.ntnu.tdt4100.bytebadger.part6;

import java.util.HashMap;
import java.util.Map;

public class BuildStatusObserverImpl implements IBuildStatusObserver {
    private Map<String, String> statuses;

    public BuildStatusObserverImpl() {
        statuses = new HashMap<>();
    }

    /**
     * This method updates the build status.
     *
     * @param buildStatus The build status object.
     */
    @Override
    public void updateBuildStatus(String buildID, String status) {
        statuses.put(buildID, status);
        System.out.println("Build " + buildID + " status updated to: " + status);
        sendNotification(buildID, status);
    }

    /**
     * This method sends a notification to the customer regarding the updated status.
     *
     * @param buildID   The build number.
     * @param status    The updated status.
     */
    private void sendNotification(String buildID, String status) {
        System.out.println("Notification: Build " + buildID + " is now " + status);
    }

    /**
     * This method gets the build status for a specific build number.
     *
     * @param buildID The build number.
     * @return The build status.
     */
    public String getBuildStatus(String buildID) {
        return statuses.get(buildID);
    }

}
