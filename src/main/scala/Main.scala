import java.io.File
import java.io.IOException
import org.eclipse.jgit.storage.file.FileRepositoryBuilder
import java.io.FileWriter
import org.eclipse.jgit.api.Git

@main def hello: Unit =

  // Workflow

  // 1. Initiate a Git repository in "../test-dir"
  val path = new File("../test-dir")

  val repository = FileRepositoryBuilder.create(new File(path, ".git"))
  repository.create()

  // 2. Create a text-file with "Hello, JGit!"
  val new_file = new File(repository.getDirectory().getParent(), "new_file");

  val file_write = new FileWriter(new_file)
  file_write.write("Hello, JGit!")
  file_write.close()

  // 3. Add that file to staging
  val git = new Git(repository)
  git.add().addFilepattern("new_file").call()

  // 4. Write a commit message
  git.commit().setMessage("Added a new file!").call()
