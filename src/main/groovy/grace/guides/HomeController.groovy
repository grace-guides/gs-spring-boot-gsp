package grace.guides

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HomeController {

	@GetMapping("/")
	String index() {
		return "index"
	}

}
