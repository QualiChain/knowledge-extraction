# Command Line Runner

The command line version can be used to execute linking tasks or entire workflows from the command line.
Parameters are configured by defining Java Properties.
The following parameters are available:

- **`configFile`**: The project file to be executed. 
- **`task`**: The task (link specification or workflow) to be executed.

The command line binary can be started like this:

`java -DconfigFile={project-file} -Dtask={task-name} -jar eccenca-dataintegration-cmd-{version}.jar`
