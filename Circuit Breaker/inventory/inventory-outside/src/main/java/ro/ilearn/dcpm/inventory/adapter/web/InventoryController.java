package ro.ilearn.dcpm.inventory.adapter.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.jboss.logging.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.ilearn.dcpm.inventory.core.ViewCurrentBookInventoryPort;


@RestController
@RequestMapping(path = "/api/v1/inventories")
public class InventoryController {

    private final Logger logger = Logger.getLogger(InventoryController.class);
    private final ViewCurrentBookInventoryPort viewCurrentBookInventoryPort;

    public InventoryController(ViewCurrentBookInventoryPort viewCurrentBookInventoryPort) {
        this.viewCurrentBookInventoryPort = viewCurrentBookInventoryPort;
    }

    @Operation(summary = "Returneaza inventarul curent al cartii identificate prin parametrul trimis")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Inventarul a fost gasit"),
            @ApiResponse(responseCode = "400", description = "Parametrul trimis este invalid")
    })
    @GetMapping("/book/{bookId}")
    public int getInventoryOfBook(@PathVariable Long bookId) {
        logger.info("Return inventory for book " + bookId);
        return viewCurrentBookInventoryPort.execute(bookId).getQuantity();
    }
}