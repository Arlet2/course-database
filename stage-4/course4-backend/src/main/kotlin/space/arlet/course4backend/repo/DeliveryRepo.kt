package space.arlet.course4backend.repo

import org.springframework.data.repository.CrudRepository
import space.arlet.course4backend.core.Delivery

interface DeliveryRepo : CrudRepository<Delivery, Int>