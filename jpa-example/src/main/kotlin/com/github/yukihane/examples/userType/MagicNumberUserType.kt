package com.github.yukihane.examples.userType

import com.github.yukihane.examples.entity.userType.MagicNumber
import org.hibernate.engine.spi.SharedSessionContractImplementor
import org.hibernate.type.IntegerType
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.Types

class MagicNumberUserType : ImmutableType<MagicNumber>(MagicNumber::class.java) {

    override fun sqlTypes(): IntArray = intArrayOf(IntegerType.INSTANCE.sqlType())


    override fun nullSafeGet(
        rs: ResultSet,
        names: Array<out String>,
        session: SharedSessionContractImplementor,
        owner: Any
    ): Any? {
        val columnName = names[0]
        val columnValue = rs.getObject(columnName)
        return if (columnValue == null) {
            null
        } else {
            MagicNumber(columnValue as Int)
        }
    }

    override fun nullSafeSet(
        st: PreparedStatement,
        value: Any?,
        index: Int,
        session: SharedSessionContractImplementor
    ) {
        if (value == null) {
            st.setNull(index, Types.INTEGER)
        } else {
            val v = (value as MagicNumber).value
            st.setInt(index, v)
        }
    }
}
