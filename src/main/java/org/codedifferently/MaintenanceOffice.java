package org.codedifferently;

public class MaintenanceOffice {


    public String assignTech(MaintenanceRequest request) {
        int s = request.getSeverity();

        if (s >= 5) return "Tech A (Emergency)";
        if (s >= 4) return "Tech B (Priority)";
        if (s >= 2) return "Tech C (Standard)";
        return "Tech D (Low)";
    }


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


    public boolean closeRequest(MaintenanceRequest request) {
        if (request == null) return false;

        if (!"DONE".equals(request.getStatus())) {
            System.out.println("Cannot close request unless status is DONE.");
            return false;
        }


        System.out.println("Request closed: " + request.getTenantName()
                + " (Apt " + request.getApartmentNumber() + ")");
        return true;
    }


}