// Code generated by dagger-compiler.  Do not edit.
package com.todo;

import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

/**
 * A {@code Binding<EditActivity>} implementation which satisfies
 * Dagger's infrastructure requirements including:
 *
 * Owning the dependency links between {@code EditActivity} and its
 * dependencies.
 *
 * Being a {@code Provider<EditActivity>} and handling creation and
 * preparation of object instances.
 *
 * Being a {@code MembersInjector<EditActivity>} and handling injection
 * of annotated fields.
 */
public final class EditActivity$$InjectAdapter extends Binding<EditActivity>
    implements Provider<EditActivity>, MembersInjector<EditActivity> {
  private Binding<Manager> manager;

  public EditActivity$$InjectAdapter() {
    super("com.todo.EditActivity", "members/com.todo.EditActivity", NOT_SINGLETON, EditActivity.class);
  }

  /**
   * Used internally to link bindings/providers together at run time
   * according to their dependency graph.
   */
  @Override
  @SuppressWarnings("unchecked")
  public void attach(Linker linker) {
    manager = (Binding<Manager>) linker.requestBinding("com.todo.Manager", EditActivity.class, getClass().getClassLoader());
  }

  /**
   * Used internally obtain dependency information, such as for cyclical
   * graph detection.
   */
  @Override
  public void getDependencies(Set<Binding<?>> getBindings, Set<Binding<?>> injectMembersBindings) {
    injectMembersBindings.add(manager);
  }

  /**
   * Returns the fully provisioned instance satisfying the contract for
   * {@code Provider<EditActivity>}.
   */
  @Override
  public EditActivity get() {
    EditActivity result = new EditActivity();
    injectMembers(result);
    return result;
  }

  /**
   * Injects any {@code @Inject} annotated fields in the given instance,
   * satisfying the contract for {@code Provider<EditActivity>}.
   */
  @Override
  public void injectMembers(EditActivity object) {
    object.manager = manager.get();
  }

}