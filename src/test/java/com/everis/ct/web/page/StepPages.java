package com.everis.ct.web.page;

import org.springframework.stereotype.Component;

@Component
public class StepPages {

    public SymphonySearchPage searchPage() {
        return new SymphonySearchPage();
    }

    public SymphonyResultsPage resultsPage() {
        return new SymphonyResultsPage();
    }

    public SymphonySettinsPage settinsPage() {
        return new SymphonySettinsPage();
    }
}
