package de.seidfred.bam.model.attribute;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QTransactionAmount is a Querydsl query type for TransactionAmount
 */
@Generated("com.mysema.query.codegen.EmbeddableSerializer")
public class QTransactionAmount extends BeanPath<TransactionAmount> {

    private static final long serialVersionUID = -955778762L;

    public static final QTransactionAmount transactionAmount = new QTransactionAmount("transactionAmount");

    public final de.seidfred.bam.rdm.QBigDecimalValueObject _super = new de.seidfred.bam.rdm.QBigDecimalValueObject(this);

    //inherited
    public final BooleanPath nullOrEmpty = _super.nullOrEmpty;

    //inherited
    public final NumberPath<java.math.BigDecimal> value = _super.value;

    public QTransactionAmount(String variable) {
        super(TransactionAmount.class,  forVariable(variable));
    }

    public QTransactionAmount(Path<? extends TransactionAmount> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTransactionAmount(PathMetadata<?> metadata) {
        super(TransactionAmount.class,  metadata);
    }

}

