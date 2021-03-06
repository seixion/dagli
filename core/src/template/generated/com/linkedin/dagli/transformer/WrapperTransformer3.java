// AUTOGENERATED CODE.  DO NOT MODIFY DIRECTLY!  Instead, please modify the transformer/WrapperTransformerX.ftl file.
// See the README in the module's src/template directory for details.
package com.linkedin.dagli.transformer;

import com.linkedin.dagli.annotation.equality.ValueEquality;
import com.linkedin.dagli.objectio.ObjectReader;
import com.linkedin.dagli.preparer.Preparer3;
import com.linkedin.dagli.preparer.PreparerContext;
import com.linkedin.dagli.producer.internal.ChildProducerInternalAPI;
import com.linkedin.dagli.reducer.Reducer;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


/**
 * Base class for a preparable transformer that wraps another transformer of the same arity (number of inputs).
 *
 * The primary use case for wrapped transformers is "decorating" another transformer to give it more descriptive names
 * for its {@code withInput(...)} methods or other "syntactic sugar".  This is especially useful for creating a
 * user-friendly transformer from a DAG.
 *
 * @param <A> the type of the first input to the transformer
 * @param <B> the type of the second input to the transformer
 * @param <C> the type of the third input to the transformer
 * @param <R> the type of result produced by the transformer
 * @param <S> the type of the transformer deriving from this base class
 */
@ValueEquality
public class WrapperTransformer3<A, B, C, R, S extends WrapperTransformer3<A, B, C, R, S>> extends
    AbstractPreparableTransformer3<A, B, C, R, PreparedTransformer3<A, B, C, R>, S> {

  private static final long serialVersionUID = 1;

  protected PreparableTransformer3<A, B, C, R, ?> _wrappedTransformer = null;

  @Override
  public void validate() {
    super.validate();
    _wrappedTransformer.validate();
  }

  @Override
  protected Collection<? extends Reducer<? super S>> getGraphReducers() {
    // replace the wrapper transformer with the wrapped transformer
    return Collections.singletonList((wrapper, context) -> context.replace(wrapper,
        ChildProducerInternalAPI.withInputsUnsafe(wrapper._wrappedTransformer, context.getParents(wrapper))));
  }

  @Override
  protected boolean hasAlwaysConstantResult() {
    return _wrappedTransformer.internalAPI().hasAlwaysConstantResult();
  }

  /**
   * Constructs a new instance that will wrap the provided transformer.
   *
   * The new instance will inherit the wrapped transformer's inputs.
   *
   * @param wrappedTransformer the transformer to wrap
   */
  public WrapperTransformer3(PreparableTransformer3<? super A, ? super B, ? super C, ? extends R, ?> wrappedTransformer) {
    setWrappedTransformer(wrappedTransformer);
  }

  /**
   * Constructs a new instance that will initially lack a wrapped transformer (this should be set during the derived
   * class' constructor using {@link #setWrappedTransformer(PreparableTransformer3)}
   */
  public WrapperTransformer3() {
  }

  /**
   * Constructs a new instance that will wrap the provided transformer.
   *
   * The new instance will inherit the wrapped transformer's inputs.
   *
   * @param wrapped the transformer to wrap
   */
  protected WrapperTransformer3<A, B, C, R, S> withWrappedTransformer(
      PreparableTransformer3<? super A, ? super B, ? super C, ? extends R, ?> wrapped) {
    return clone(c -> c.setWrappedTransformer(wrapped));
  }

  /**
   * Sets the wrapped transformer and inherits its inputs (which become this instance's inputs).   This method should
   * <strong>only</strong> be called on new instances before they are returned to the client (e.g. during a
   * constructor).
   *
   * @param wrapped the wrapped transformer
   */
  protected void setWrappedTransformer(PreparableTransformer3<? super A, ? super B, ? super C, ? extends R, ?> wrapped) {
    _wrappedTransformer = PreparableTransformer3.castWithGenericPrepared(wrapped);
    _input1 = _wrappedTransformer.internalAPI().getInput1();
    _input2 = _wrappedTransformer.internalAPI().getInput2();
    _input3 = _wrappedTransformer.internalAPI().getInput3();
    // replace _wrapped's inputs with placeholders to avoid storing references to the original inputs when/if the
    // wrapper transformer's inputs change
    _wrappedTransformer = Transformer.withPlaceholderInputs(_wrappedTransformer);
  }

  @Override
  protected boolean hasIdempotentPreparer() {
    return _wrappedTransformer.internalAPI().hasIdempotentPreparer();
  }

  @Override
  protected Preparer3<A, B, C, R, PreparedTransformer3<A, B, C, R>> getPreparer(PreparerContext context) {
    return Preparer3.cast(_wrappedTransformer.internalAPI().getPreparer(context));
  }

  /**
   * Base class for a prepared transformer that wraps another transformer of the same arity (number of inputs).
   *
   * The primary use case for wrapped transformers is "decorating" another transformer to give it more descriptive names
   * for its {@code withInput(...)} methods or other "syntactic sugar".  This is especially useful for creating a
   * user-friendly transformer from a DAG.
   *
  * @param <A> the type of the first input to the transformer
  * @param <B> the type of the second input to the transformer
  * @param <C> the type of the third input to the transformer
  * @param <R> the type of result produced by the transformer
   * @param <S> the type of the transformer deriving from this base class
   */
  @ValueEquality
  public static abstract class Prepared<A, B, C, R, S extends WrapperTransformer3.Prepared<A, B, C, R, S>> extends
      AbstractPreparedStatefulTransformer3<A, B, C, R, Object, S> {

    private static final long serialVersionUID = 1;

    protected PreparedTransformer3<A, B, C, R> _wrappedTransformer = null;

    @Override
    public void validate() {
      super.validate();
      _wrappedTransformer.validate();
    }

    @Override
    protected Collection<? extends Reducer<? super S>> getGraphReducers() {
      // replace the wrapper transformer with the wrapped transformer
      return Collections.singletonList((wrapper, context) -> context.replace(wrapper,
          ChildProducerInternalAPI.withInputsUnsafe(wrapper._wrappedTransformer, context.getParents(wrapper))));
    }

    @Override
    protected boolean hasAlwaysConstantResult() {
      return _wrappedTransformer.internalAPI().hasAlwaysConstantResult();
    }

    /**
     * Constructs a new instance that will wrap the provided transformer.
     *
     * The new instance will inherit the wrapped transformer's inputs.
     *
     * @param wrappedTransformer the transformer to wrap
     */
    public Prepared(PreparedTransformer3<? super A, ? super B, ? super C, ? extends R> wrappedTransformer) {
      setWrappedTransformer(wrappedTransformer);
    }

    /**
     * Constructs a new instance that will initially lack a wrapped transformer (this should be set during the derived
     * class' constructor using {@link #setWrappedTransformer(PreparedTransformer3)}
     */
    public Prepared() {
    }

    /**
     * Constructs a new instance that will wrap the provided transformer.
     *
     * The new instance will inherit the wrapped transformer's inputs.
     *
     * @param wrapped the transformer to wrap
     */
    protected WrapperTransformer3.Prepared<A, B, C, R, S> withWrappedTransformer(
        PreparedTransformer3<? super A, ? super B, ? super C, ? extends R> wrapped) {
      return clone(c -> c.setWrappedTransformer(wrapped));
    }

    /**
     * Sets the wrapped transformer and inherits its inputs (which become this instance's inputs).   This method should
     * <strong>only</strong> be called on new instances before they are returned to the client (e.g. during a
     * constructor).
     *
     * @param wrapped the wrapped transformer
     */
    protected void setWrappedTransformer(PreparedTransformer3<? super A, ? super B, ? super C, ? extends R> wrapped) {
      _wrappedTransformer = PreparedTransformer3.cast(wrapped);
      _input1 = _wrappedTransformer.internalAPI().getInput1();
      _input2 = _wrappedTransformer.internalAPI().getInput2();
      _input3 = _wrappedTransformer.internalAPI().getInput3();
      // replace _wrapped's inputs with placeholders to avoid storing references to the original inputs when/if the
      // wrapper transformer's inputs change
      _wrappedTransformer = Transformer.withPlaceholderInputs(_wrappedTransformer);
    }

    @Override
    public R apply(A value1, B value2, C value3) {
      return _wrappedTransformer.apply(value1, value2, value3);
    }

    @Override
    public ObjectReader<R> applyAll(Iterable<? extends A> values1, Iterable<? extends B> values2,
        Iterable<? extends C> values3) {
      return _wrappedTransformer.applyAll(values1, values2, values3);
    }

    @Override
    protected R apply(Object executionCache, A value1, B value2, C value3) {
      return _wrappedTransformer.internalAPI().apply(executionCache, value1, value2, value3);
    }

    @Override
    protected void applyAll(Object executionCache, List<? extends A> values1, List<? extends B> values2,
        List<? extends C> values3, List<? super R> results) {
      _wrappedTransformer.internalAPI().applyAllUnsafe(executionCache, values1.size(),
          Arrays.asList(values1, values2, values3), results);
    }

    @Override
    protected Object createExecutionCache(long exampleCountGuess) {
      return _wrappedTransformer.internalAPI().createExecutionCache(exampleCountGuess);
    }

    @Override
    protected int getPreferredMinibatchSize() {
      return super.getPreferredMinibatchSize();
    }
  }
}
