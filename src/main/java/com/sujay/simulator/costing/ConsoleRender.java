package com.sujay.simulator.costing;

import java.util.Set;

public class ConsoleRender implements CostReportRender {
    @Override
    public void renderReport(CostReport report) {
        printHeader();
        printDetails(report.getItems());
        printFooter(report.getItems());
    }

    private void printHeader() {
        String formatString = "%s %60s %10s\n";
        System.out.printf(formatString, "Item", "Quantity", "Cost");
    }

    private void printDetails(Set<CostReportItem> items) {
        for (CostReportItem item : items) {
            int length = item.getDescription().length();
            int totalSpaces = 60 - length;
            String formatString = "%s%" + totalSpaces + "s %d %10d\n";
            System.out.printf(formatString, item.getDescription(), " ", item.getQuantity(), item.getCost());
        }
    }

    private void printFooter(Set<CostReportItem> items) {
        String formatString = "%s%69d\n";
        Integer totalCost = items.stream()
                .map(CostReportItem::getCost)
                .reduce(0, Integer::sum);
        System.out.println("-".repeat(75));
        System.out.printf(formatString, "Total", totalCost);
        System.out.println();
    }


}
