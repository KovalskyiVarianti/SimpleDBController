package specification.sql

import entities.Entity
import specification.ReturnableSpecification

interface SqlReturnableSpecification<T:Entity>:ReturnableSpecification<T> {
}