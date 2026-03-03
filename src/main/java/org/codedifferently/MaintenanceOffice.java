package org.codedifferently;

public class MaintenanceOffice {

    /**
     * Assign a technician name based on severity.
     * You can change the names / logic as needed.
     */
    public String assignTech(MaintenanceRequest request) {
        int s = request.getSeverity();

        if (s >= 5) return "Tech A (Emergency)";
        if (s >= 4) return "Tech B (Priority)";
        if (s >= 2) return "Tech C (Standard)";
        return "Tech D (Low)";
    }

    /**
     * Updates the request status ONLY if it's one of:
     * NEW, IN_PROGRESS, DONE
     */
    public boolean updateStatus(MaintenanceRequest request, String newStatus) {
        if (newStatus == null) return false;

        String format = newStatus.trim().toUpperCase();

        if (!format.equals("NEW") && !format.equals("IN_PROGRESS") && !format.equals("DONE")) {
            System.out.println("Invalid status. Allowed: NEW, IN_PROGRESS, DONE");
            return false;
        }

        request.setStatus(format);
        return true;
    }

    /**
     * Closes a request only if status is DONE.
     */
    public boolean closeRequest(MaintenanceRequest request) {
        if (request == null) return false;

        if (!"DONE".equals(request.getStatus())) {
            System.out.println("Cannot close request unless status is DONE.");
            return false;
        }

        // If your model treats DONE as "closed", then closing is essentially confirming it.
        // If you want a separate CLOSED status, you *can't* add it because rules forbid it.
        System.out.println("Request closed: " + request.getTenantName()
                + " (Apt " + request.getApartmentNumber() + ")");
        return true;
    }


}