package com.store.entity;

import java.sql.Types;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.dialect.PostgreSQL9Dialect;
import org.hibernate.type.descriptor.sql.BinaryTypeDescriptor;
import org.hibernate.type.descriptor.sql.SqlTypeDescriptor;

/** Custom postgres for blobs */
@Slf4j
public class CustomPostgreSQLDialect extends PostgreSQL9Dialect {

  @SuppressWarnings("unused")
  public CustomPostgreSQLDialect() {
    log.info("Init CustomPostgreSQLDialect **********************************");
    registerColumnType(Types.BLOB, "bytea");
  }

  @Override
  public SqlTypeDescriptor remapSqlTypeDescriptor(SqlTypeDescriptor sqlTypeDescriptor) {
    if (sqlTypeDescriptor.getSqlType() == Types.BLOB) {
      return BinaryTypeDescriptor.INSTANCE;
    }
    return super.remapSqlTypeDescriptor(sqlTypeDescriptor);
  }
}
