package com.github.yukihane.examples.entity.userType

import org.hibernate.annotations.Type
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class HasMagicNumber(
    @Type(type = "com.github.yukihane.examples.userType.MagicNumberUserType")
    var magicNumber: MagicNumber?
) {
    @Id
    @GeneratedValue
    private var id: Long? = null
}
