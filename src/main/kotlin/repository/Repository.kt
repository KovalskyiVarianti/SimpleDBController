package repository

import specification.ReturnableSpecification
import specification.Specification

interface Repository<T> {
    fun add(item: T)
    fun remove(id: Int)
    fun update(item: T)
    fun showAll(): List<T>
    fun <S> query(returnableSpecification: S): List<T>
            where S : Specification,
                  S : ReturnableSpecification

}