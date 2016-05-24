package de.seidfred.bam.model.attribute;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QFixValue is a Querydsl query type for FixValue
 */
@Generated("com.mysema.query.codegen.EmbeddableSerializer")
public class QFixValue extends BeanPath<FixValue> {

    private static final long serialVersionUID = -2009963012L;

    public static final QFixValue fixValue = new QFixValue("fixValue");

    public final de.seidfred.bam.rdm.QBigDecimalValueObject _super = new de.seidfred.bam.rdm.QBigDecimalValueObject(this);

    //inherited
    public final BooleanPath nullOrEmpty = _super.nullOrEmpty;

    //inherited
    public final NumberPath<java.math.BigDecimal> value = _super.value;

    public QFixValue(String variable) {
        super(FixValue.class,  forVariable(variable));
    }

    public QFixValue(Path<? extends FixValue> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFixValue(PathMetadata<?> metadata) {
        super(FixValue.class,  metadata);
    }

}

