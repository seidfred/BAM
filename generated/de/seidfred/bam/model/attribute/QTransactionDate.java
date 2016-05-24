package de.seidfred.bam.model.attribute;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QTransactionDate is a Querydsl query type for TransactionDate
 */
@Generated("com.mysema.query.codegen.EmbeddableSerializer")
public class QTransactionDate extends BeanPath<TransactionDate> {

    private static final long serialVersionUID = -1846724596L;

    public static final QTransactionDate transactionDate = new QTransactionDate("transactionDate");

    public final de.seidfred.bam.rdm.QDateValueObject _super = new de.seidfred.bam.rdm.QDateValueObject(this);

    //inherited
    public final BooleanPath nullOrEmpty = _super.nullOrEmpty;

    //inherited
    public final DatePath<java.util.Date> value = _super.value;

    public QTransactionDate(String variable) {
        super(TransactionDate.class,  forVariable(variable));
    }

    public QTransactionDate(Path<? extends TransactionDate> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTransactionDate(PathMetadata<?> metadata) {
        super(TransactionDate.class,  metadata);
    }

}

