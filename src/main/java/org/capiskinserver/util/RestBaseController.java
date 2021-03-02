package org.capiskinserver.util;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/api")
@ResponseBody
@CrossOrigin(origins = "*")
public class RestBaseController {

}
