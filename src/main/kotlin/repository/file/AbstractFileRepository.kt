package repository.file

import entities.Clothes
import entities.Entity
import repository.Repository
import specification.ReturnableSpecification
import specification.Specification
import specification.file.FileReturnableSpecification
import specification.file.FileSpecification

abstract class AbstractFileRepository<T : Entity> : Repository<T> {
    protected fun castToReturnableFileSpec(returnableSpecification: ReturnableSpecification<T>) =
        returnableSpecification as FileReturnableSpecification<T>

    protected fun castToFileSpec(specification: Specification<T>) =
        specification as FileSpecification<T>
}