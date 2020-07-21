package controllers;

import Service.IbanService;
import play.mvc.*;
import java.util.Map;

public class HomeController extends Controller {


    public Result index() {
        return ok(views.html.index.render());
    }


    public Result resultPost(Http.Request request) {

        Map<String, String[]> params = request.body().asFormUrlEncoded();

        String countryCode = params.get("countryCode")[0];
        String bankCode = params.get("bankCode")[0];

        IbanService ibanCode = new IbanService(countryCode,bankCode);
        String finalCode = ibanCode.getNormalizedIban();

        return ok(views.html.results.render(finalCode));
    }

}
