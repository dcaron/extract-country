/*
 * Copyright 2021-2022 VMware, Inc.
 * SPDX-License-Identifier: BSD-2-Clause
 */

package functions;

import java.util.function.Function;

import functions.models.*;

import org.springframework.cloud.function.cloudevent.CloudEventMessageBuilder;
import org.springframework.messaging.Message;

/*
This class demonstrates the definition of a function called "Handler".
This function can be accessed by targeting the "/handler" path while
providing the correct data:
    {
        "specversion" : "1.0",
        "type" : "hire",
        "source" : "https://spring.io/",
        "id" : "A234-1234-1234",
        "datacontenttype" : "application/json",
        "data": {
            "firstName": "John",
            "lastName": "Doe"
        }
    }
If this is the only function defined, it may be accessed via "/"
path.
*/
public class Handler implements Function<Message<PositionData>, Message<Country>> {
    @Override
    public Message<Country> apply(Message<PositionData> msg) {
        String ceType = (String) msg.getHeaders().get("ce-type");
        if (ceType == null || !ceType.equals("positionData")) {
            throw new RuntimeException("Did not receive a header 'ce-type' with value 'positionData'");
        }

        PositionData positionData = msg.getPayload();
        System.out.printf("positionData: flight(%s) hex(%s)\n", positionData.getFlight(), positionData.getHex());
        Country country = CountryUtil.findByICAO(positionData.getHex());
        System.out.printf("Country: %s\n", country.getName());
        return CloudEventMessageBuilder.withData(country).build();
    }
}
