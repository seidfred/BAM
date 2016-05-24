package de.seidfred.bam.model.attribute;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QIdentity is a Querydsl query type for Identity
 */
@Generated("com.mysema.query.codegen.EmbeddableSerializer")
public class QIdentity extends BeanPath<Identity> {

    private static final long serialVersionUID = -1740276642L;

    public static final QIdentity identity = new QIdentity("identity");

    public final de.seidfred.bam.rdm.QUuidValueObject _super = new de.seidfred.bam.rdm.QUuidValueObject(this);

    //inherited
    public final BooleanPath nullOrEmpty = _super.nullOrEmpty;

    //inherited
    public final StringPath value = _super.value;

    public QIdentity(String variable) {
        super(Identity.class,  forVariable(variable));
    }

    public QIdentity(Path<? extends Identity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QIdentity(PathMetadata<?> metadata) {
        super(Identity.class,  metadata);
    }

}

