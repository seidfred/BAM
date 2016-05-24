package de.seidfred.bam.rdm;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QBigDecimalValueObject is a Querydsl query type for BigDecimalValueObject
 */
@Generated("com.mysema.query.codegen.EmbeddableSerializer")
public class QBigDecimalValueObject extends BeanPath<BigDecimalValueObject> {

    private static final long serialVersionUID = -133544093L;

    public static final QBigDecimalValueObject bigDecimalValueObject = new QBigDecimalValueObject("bigDecimalValueObject");

    public final QAbstractSimpleValueObject _super = new QAbstractSimpleValueObject(this);

    //inherited
    public final BooleanPath nullOrEmpty = _super.nullOrEmpty;

    public final NumberPath<java.math.BigDecimal> value = createNumber("value", java.math.BigDecimal.class);

    public QBigDecimalValueObject(String variable) {
        super(BigDecimalValueObject.class,  forVariable(variable));
    }

    public QBigDecimalValueObject(Path<? extends BigDecimalValueObject> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBigDecimalValueObject(PathMetadata<?> metadata) {
        super(BigDecimalValueObject.class,  metadata);
    }

}

