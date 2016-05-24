package de.seidfred.bam.rdm;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QAbstractSimpleValueObject is a Querydsl query type for AbstractSimpleValueObject
 */
@Generated("com.mysema.query.codegen.EmbeddableSerializer")
public class QAbstractSimpleValueObject extends BeanPath<AbstractSimpleValueObject<? extends Comparable<?>>> {

    private static final long serialVersionUID = -696799424L;

    public static final QAbstractSimpleValueObject abstractSimpleValueObject = new QAbstractSimpleValueObject("abstractSimpleValueObject");

    public final BooleanPath nullOrEmpty = createBoolean("nullOrEmpty");

    public final SimplePath<Comparable<?>> value = createSimple("value", Comparable.class);

    @SuppressWarnings("all")
    public QAbstractSimpleValueObject(String variable) {
        super((Class)AbstractSimpleValueObject.class,  forVariable(variable));
    }

    @SuppressWarnings("all")
    public QAbstractSimpleValueObject(Path<? extends AbstractSimpleValueObject> path) {
        super((Class)path.getType(), path.getMetadata());
    }

    @SuppressWarnings("all")
    public QAbstractSimpleValueObject(PathMetadata<?> metadata) {
        super((Class)AbstractSimpleValueObject.class,  metadata);
    }

}

