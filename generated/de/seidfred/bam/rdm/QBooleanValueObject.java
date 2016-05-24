package de.seidfred.bam.rdm;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QBooleanValueObject is a Querydsl query type for BooleanValueObject
 */
@Generated("com.mysema.query.codegen.EmbeddableSerializer")
public class QBooleanValueObject extends BeanPath<BooleanValueObject> {

    private static final long serialVersionUID = 445883140L;

    public static final QBooleanValueObject booleanValueObject = new QBooleanValueObject("booleanValueObject");

    public final QAbstractSimpleValueObject _super = new QAbstractSimpleValueObject(this);

    //inherited
    public final BooleanPath nullOrEmpty = _super.nullOrEmpty;

    public final BooleanPath value = createBoolean("value");

    public QBooleanValueObject(String variable) {
        super(BooleanValueObject.class,  forVariable(variable));
    }

    public QBooleanValueObject(Path<? extends BooleanValueObject> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBooleanValueObject(PathMetadata<?> metadata) {
        super(BooleanValueObject.class,  metadata);
    }

}

