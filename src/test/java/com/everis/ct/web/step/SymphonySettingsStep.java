package com.everis.ct.web.step;

import com.everis.ct.web.page.StepPages;
import com.everis.ct.web.service.aspect.evidence.ScreenShot;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ScreenShot
public class SymphonySettingsStep {

    @Autowired
    private StepPages page;

    public void searchSettings(String option) {
        page.settinsPage().searchSettings(option);
    }

    public void validateValueResult(String result) {
        Assert.assertEquals("El valor del resultado obtenido no corresponde con el valore esperado.",
                result, page.settinsPage().getValueResult());
    }
}