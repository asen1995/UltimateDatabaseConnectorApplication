package org.db.connectors.controller;

import org.db.connectors.model.MariaDbModel;
import org.db.connectors.service.MariaDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MariaDbController {

    @Autowired
    MariaDbService mariaDbService;

    @RequestMapping(value = "insertMariaDbModel", method = RequestMethod.POST)
    public String insertMariaDbModel(@RequestBody MariaDbModel mariaDbModel) throws Exception {
        return mariaDbService.insertMariaDbModel(mariaDbModel);
    }


}
