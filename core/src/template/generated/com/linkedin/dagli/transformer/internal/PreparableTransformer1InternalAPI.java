// AUTOGENERATED CODE.  DO NOT MODIFY DIRECTLY!  Instead, please modify the transformer/internal/PreparableTransformerXInternalAPI.ftl file.
// See the README in the module's src/template directory for details.
package com.linkedin.dagli.transformer.internal;

import com.linkedin.dagli.objectio.ConcatenatedReader;
import com.linkedin.dagli.transformer.PreparableTransformer1;
import com.linkedin.dagli.transformer.PreparedTransformer1;
import com.linkedin.dagli.preparer.Preparer1;
import com.linkedin.dagli.preparer.PreparerContext;
import com.linkedin.dagli.preparer.PreparerResultMixed;
import com.linkedin.dagli.dag.DAGExecutor;
import java.util.Collection;
import com.linkedin.dagli.objectio.ObjectIterator;
import com.linkedin.dagli.objectio.ObjectReader;

import com.linkedin.dagli.dag.DAG;
import com.linkedin.dagli.placeholder.Placeholder;
import com.linkedin.dagli.producer.Producer;

import com.linkedin.dagli.transformer.PreparableTransformer2;
import com.linkedin.dagli.transformer.PreparedTransformer2;


public interface PreparableTransformer1InternalAPI<A, R, N extends PreparedTransformer1<A, R>, S extends PreparableTransformer1<A, R, N>>
    extends Transformer1InternalAPI<A, R, S>, PreparableTransformerInternalAPI<R, N, S> {

  @Override
  Preparer1<A, R, N> getPreparer(PreparerContext context);

  default PreparerResultMixed<? extends PreparedTransformer1<? super A, ? extends R>, N> prepare(
      PreparerContext context, Iterable<? extends A> values1) {
    Preparer1<A, R, N> preparer = getPreparer(context);

    try (ObjectIterator<? extends A> iter1 = ObjectIterator.wrap(values1.iterator())) {
      while (iter1.hasNext()) {
        preparer.process(iter1.next());
      }

    }

    return preparer.finishUnsafe(new ConcatenatedReader<>(Object[]::new, ObjectReader.wrap(values1)));
  }

  default PreparerResultMixed<? extends PreparedTransformer1<? super A, ? extends R>, N> prepare(DAGExecutor executor,
      Collection<? extends A> values1) {
    return prepare(PreparerContext.builder(values1.size()).setExecutor(executor).build(), values1);
  }

  @Override
  default <B> PreparableTransformer2<A, B, R, ? extends PreparedTransformer2<A, B, R>> withArity2(
      Producer<? extends B> newInput2) {
    Placeholder<A> nestedPlaceholder1 = new Placeholder<>("Original Input 1");
    return DAG.withPlaceholders(nestedPlaceholder1, new Placeholder<B>("Ignored"))
        .withOutput(withInputs(nestedPlaceholder1)).withInputs(getInput1(), newInput2);
  }

  @Override
  default <N> PreparableTransformer2<N, A, R, ? extends PreparedTransformer2<N, A, R>> withPrependedArity2(
      Producer<? extends N> newInput1) {
    Placeholder<A> nestedPlaceholder1 = new Placeholder<>("Original Input 1");
    return DAG.withPlaceholders(new Placeholder<N>("Ignored"), nestedPlaceholder1)
        .withOutput(this.withInputs(nestedPlaceholder1)).withInputs(newInput1, getInput1());
  }
}
