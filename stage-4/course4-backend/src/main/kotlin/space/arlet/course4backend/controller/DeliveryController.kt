package space.arlet.course4backend.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import space.arlet.course4backend.core.Delivery
import space.arlet.course4backend.exceptions.EntityNotFound
import space.arlet.course4backend.repo.DeliveryRepo

@RestController
class DeliveryController(
    @Autowired val deliveryRepo: DeliveryRepo,
) {

    @Operation(summary = "Get all deliveries")
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200", description = "Successfully getting all deliveries",
                content = arrayOf(
                    Content(mediaType = "application/json", schema = Schema(implementation = Delivery::class))
                )
            ),
            ApiResponse(
                responseCode = "404", description = "No such delivery was found", content = arrayOf(Content())
            ),
            ApiResponse(
                responseCode = "500", description = "Internal error", content = arrayOf(Content()),
            )
        ]
    )
    @GetMapping("\${api.path}/deliveries")
    fun getDeliveries(): List<Delivery> {
        val deliveries = deliveryRepo.findAll().toList()

        if (deliveries.isEmpty()) {
            throw EntityNotFound()
        }

        return deliveries
    }
}