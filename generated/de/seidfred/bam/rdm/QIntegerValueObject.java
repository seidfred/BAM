package de.seidfred.bam.rdm;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QIntegerValueObject is a Querydsl query type for IntegerValueObject
 */
@Generated("com.mysema.query.codegen.EmbeddableSerializer")
public class QIntegerValueObject extends BeanPath<IntegerValueObject> {

    private static final long serialVersionUID = -1186028498L;

    public static final QIntegerValueObject integerValueObject = new QIntegerValueObject("integerValueObject");

    public final QAbstractSimpleValueObject _super = new QAbstractSimpleValueObject(this);

    //inherited
    public final BooleanPath nullOrEmpty = _super.nullOrEmpty;

    public final NumberPath<Integer> value = createNumber("value", Integer.class);

    public QIntegerValueObject(String variable) {
        super(IntegerValueObject.class,  forVariable(variable));
    }

    public QIntegerValueObject(Path<? extends IntegerValueObject> path) {
        super(path.getType(), path.getMetadata());
    }

    public QIntegerValueObject(PathMetadata<?> metadata) {
        super(IntegerValueObject.class,  metadata);
    }

}

